package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1890 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// N x N 사이즈 게임판 입력
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int info = Integer.parseInt(st.nextToken());
				board[i][j] = info;
			}
		}

		// N x N 사이즈 dp 계산 
		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 마지막 칸 도착하면 출력 및 종료 
				if (i == N - 1 && j == N - 1) {
					System.out.println(dp[N - 1][N - 1]);
					break;
				}
				
				int number = board[i][j];
				
				// i + number 행 
				if (i + number < N) {
					dp[i + number][j] += dp[i][j];
				}
				
				// j + number 열 
				if (j + number < N) {
					dp[i][j + number] += dp[i][j];
				}
			}
		}
		
	}

}
