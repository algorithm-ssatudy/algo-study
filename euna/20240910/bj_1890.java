package bj;


import java.util.Scanner;

public class bj_1890 {
	static int N, cnt;
	static int[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j] ==0) continue;
					
			
				if (j + arr[i][j] < N) {
					dp[i][j + arr[i][j]] += dp[i][j];
				}
				if (i + arr[i][j] < N) {
					dp[i + arr[i][j]][j] += dp[i][j];
				}
				
				}

			}
		System.out.println(dp[N - 1][N - 1]);
		}
		

	}

