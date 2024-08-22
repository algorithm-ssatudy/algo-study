package codingTest;

import java.util.Scanner;

public class c2578 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 1. 빙고판 각 칸에 비트마스크 저장
		int[][] board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = (1 << sc.nextInt());
			}
		}

		// 1.1. 12개 라인으로 별도 저장 (각 라인 합한 값)
		int[] lineSum = new int[12];
		int lineIndex = 0;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				// 가로 라인 5개
				lineSum[lineIndex] += board[i][j];
				// 세로 라인 5개
				lineSum[lineIndex + 5] += board[j][i];
			}
			lineIndex++;
			
			// 대각선 "\"
			lineSum[10] += board[i][i];
			
			// 대각선 "/"
			lineSum[11] += board[4 - i][i];
		}


		// 빙고 갯수
		int bingo = 0;

		// 2. 사회자 숫자 호출 시작
		for (int i = 1; i <= 25; i++) {
			int callNum = sc.nextInt();
			int bit = 1 << callNum;

			// 2.2. 숫자 호출 될 때마다 각 12개 라인에서 그 숫자 있으면 minus
			for (int j = 0; j < 12; j++) {
				if ((lineSum[j] & bit) == bit) {
					lineSum[j] -= bit;
					// 한 줄의 합계가 다 minus 되어 0이 된다면 빙고
					if (lineSum[j] == 0) {
						bingo++;
					}

					// 빙고 3개되면 얼른 break
					if (bingo >= 3) {
						break;
					}
				}
			}

			if (bingo >= 3) {
				System.out.println(i);
				break;
			}
		}
	}

}
