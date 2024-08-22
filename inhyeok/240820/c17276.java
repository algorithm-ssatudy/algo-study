package codingTest;

import java.util.Arrays;
import java.util.Scanner;

public class c17276 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int round = 1; round <= T; round++) {
			int n = sc.nextInt();
			int d = sc.nextInt();

			// n x n 사이즈 배열 생성
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// ㅣ / ㅡ \ 순서
			int[][] lines = new int[8][n];

			// 라인 1 ~ 4
			// 1. 라인 저장 '|'
			int x = (int) (n / 2);
			for (int y = 0; y < n; y++) {
				lines[0][y] = arr[y][x];
			}

			// 2. 라인 저장 '/'
			x = n - 1;
			for (int y = 0; y < n; y++) {
				lines[1][y] = arr[y][x - y];
			}

			// 3. 라인 저장 '-'
			int y = (int) (n / 2);
			for (x = n - 1; x >= 0; x--) {
				lines[2][n - 1 - x] = arr[y][x];
			}

			// 4. 라인 저장 '\'
			for (y = n - 1; y >= 0; y--) {
				lines[3][n - 1 - y] = arr[y][y];
			}

			// 라인 5 ~ 8 (reverse) 
			for (int i = 0; i < n; i++) {
				lines[4][i] = lines[0][n - 1 - i];
				lines[5][i] = lines[1][n - 1 - i];
				lines[6][i] = lines[2][n - 1 - i];
				lines[7][i] = lines[3][n - 1 - i];
			}

			// d의 방향이 양수 -> 배열이 우측으로 돌아감 -> Head Index가 음수가 되어버림 -> 그러므로 d를 기본적으로 음수로 설정 
			d = d * -1;
			int direction = ((int) (d + 360) / 45) % 8; // 8개의 각도 

			// 만약 d가 2라면 : "|, /, -, \" 모양대로 lines에 저장된 2, 3, 4, 5번째 라인이 순차적으로 들어감
			// 만약 d가 6이라면 : "|, /, -, \" 모양대로 lines에 저장된 6, 7, 0, 1번째 라인이 순차적으로 들어감
			
			// ㅣ 라인 그리기 (중심) 
			x = (int) (n / 2);
			for (y = 0; y < n; y++) {
				arr[y][x] = lines[(0 + direction) % 8][y];
			}

			// / 라인 
			x = n - 1;
			for (y = 0; y < n; y++) {
				arr[y][x - y] = lines[(1 + direction) % 8][y];
			}

			// ㅡ 라인 
			y = (int) (n / 2);
			for (x = n - 1; x >= 0; x--) {
				arr[y][x] = lines[(2 + direction) % 8][n - 1 - x];
			}

			// \ 라인 
			for (y = n - 1; y >= 0; y--) {
				arr[y][y] = lines[(3 + direction) % 8][n - 1 - y];
			}

			// 회전 마친 배열 출력 
			for (int i = 0; i < n; i++) {

				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
