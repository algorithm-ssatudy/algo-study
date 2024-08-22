package codingTest;

import java.util.Scanner;

public class c11055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			dp[i] = arr[i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
		}
		
		int maxSum = 0;
		for (int i = 0; i < n; i++) {
			if(maxSum < dp[i]) {
				maxSum = dp[i];
			}
		}
		System.out.println(maxSum);
	}

}
