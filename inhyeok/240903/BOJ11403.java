package codingTest;

import java.util.Scanner;

public class BOJ11403 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 인접행렬 입력
		int[][] adjArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adjArr[i][j] = sc.nextInt();
			}
		}

		// 플로이드 워셜
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// k 노드 거쳐 가는 길이 존재한다면 길이 존재함(1)으로 변경
					adjArr[i][j] = adjArr[i][j] | (adjArr[i][k] & adjArr[k][j]);
				}
			}
		}

		// 결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjArr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
