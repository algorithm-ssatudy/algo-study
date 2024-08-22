import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {

	
	static int T;
	public static class Pair {
		//문서의 중요도와 순서 저장 
		int v; //중요도 
		int idx; //순서 
		public Pair(int v, int idx) {
			this.v=v;
			this.idx=idx;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T=Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			int M, N;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //문서 개수  
			M = Integer.parseInt(st.nextToken()); //몇번째로 나타나는지
			Queue<Pair> q = new LinkedList<>(); //중요도와 순서
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //중요도 내림차순 
			
			int cnt = 0; //몇번째로 pop되는지
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int v= Integer.parseInt(st.nextToken());
				q.add(new Pair(v, i));
				pq.add(v);
			}
			while(!q.isEmpty()) {
				int curV=q.peek().v; //가장 앞에 있는 문서의 중요도
				int curI=q.peek().idx; 
				q.poll();
				//남은 문서 중 중요도가 높은 문서 있는지 확인 
				if(curV==pq.peek()) {
					//남은 문서 중 현재 문서보다 중요도가 높은 문서가 없다
					pq.poll(); //인쇄
					cnt++;
					if(curI==M) {
						System.out.println(cnt);
					}
				}
				else {
					//인쇄하지 않고 뒤에 재배
					q.add(new Pair(curV, curI));
				}
				
			}
		}
		

	}

}
