package codingTest;

import java.util.Scanner;

public class c16395 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[][] arr = new int[30][30];

		for (int i = 0; i <= 29; i++) {
			arr[0][i] = 1;
			arr[i][0] = 1;
		}

		for (int i = 1; i <= (n - k); i++) {
			for (int j = 1; j < k; j++) {
				arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
			}
		}
		
		System.out.println(arr[n-k][k-1]);
	}

}
