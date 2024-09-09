import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BOJ12851 {

	static int dist[];
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		dist=new int[100001];
		Arrays.fill(dist, -1);
		dist[N]=0;
		Queue<Integer> q=new ArrayDeque<>();
		q.add(N);
		int cnt=0;
		while(!q.isEmpty()) {
			int cur=q.poll();
			if(cur==K) {
				cnt++;
			}
			if(cur-1>=0 && (dist[cur-1]==-1 || (dist[cur-1]!=-1 && dist[cur-1]>=dist[cur]+1))) {
				dist[cur-1]=dist[cur]+1;
				q.add(cur-1);
			}
			if(cur+1<=100000 && (dist[cur+1]==-1 || (dist[cur+1]!=-1 && dist[cur+1]>=dist[cur]+1))) {
				dist[cur+1]=dist[cur]+1;
				q.add(cur+1);
			}
			if(2*cur<=100000 && (dist[2*cur]==-1 || (dist[2*cur]!=-1 && dist[2*cur]>=dist[cur]+1))) {
				dist[2*cur]=dist[cur]+1;
				q.add(2*cur);
			}
		}
		System.out.println(dist[K]);
		System.out.println(cnt);
	}

}
