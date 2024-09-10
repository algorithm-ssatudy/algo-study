
package bj;

import java.util.Scanner;

public class bj_15651 {
	static int N, M;
	static int[] result;
	static StringBuilder sb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		sb = new StringBuilder();
		
		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int idx) {
		// TODO Auto-generated method stub
		if(idx ==M) {
			for(int i=0; i < M;i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i = 1; i <= N; i++) {

			result[idx] = i;
			dfs(idx+1);

		}
	}

}
