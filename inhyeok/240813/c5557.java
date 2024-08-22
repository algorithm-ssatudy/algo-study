package codingTest;

import java.util.Arrays;
import java.util.Scanner;

public class c5557 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 어차피 각 단계에서 중간 과정은 0~20 범위
		long[][] dp = new long[n][21];
		dp[0][arr[0]] = 1;

		// 0 ~ n - 2 까지
		for (int i = 1; i <= n - 2; i++) {

			// 앞 단계 계산 결과 탐색 (0~20 사이)
			for (int j = 0; j <= 20; j++) {
				// 계산 결과가 존재한다면 이번 수를 1. 더하기, 2. 빼기
				if (dp[i - 1][j] != 0) {
					// 1. plus
					if (j + arr[i] <= 20) {
						dp[i][j + arr[i]] += dp[i-1][j];
					}

					// 2. minus
					if (j - arr[i] >= 0) {
						dp[i][j - arr[i]] += dp[i-1][j];
					}
				}
			}
		}
		
//		for(int i=0 ; i<n ; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}

		System.out.println(dp[n-2][arr[n-1]]);
	}

}
