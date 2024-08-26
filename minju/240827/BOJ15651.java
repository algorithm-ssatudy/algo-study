import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15651 {

	static int N, M;
	static int res[];
	static StringBuilder sb = new StringBuilder();
	static void dfs(int depth, int idx) {
		if(depth==M) {
			for(int i=0;i<M;i++) {
				sb.append(res[i]+" ");
			}
			sb.append('\n');
			return;
		}
		for(int i=1;i<=N;i++) {
			res[depth]=i;
			dfs(depth+1, i+1);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 1부터 N까지 중 M개 고름
		
		res=new int[M];
		
		dfs(0, 1);
		System.out.print(sb);
	}

}
