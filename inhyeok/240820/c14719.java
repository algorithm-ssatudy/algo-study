package codingTest;

import java.util.Scanner;

public class c14719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int W = sc.nextInt();

		int[] columns = new int[W];
		for (int i = 0; i < W; i++) {
			columns[i] = sc.nextInt();
		}

		int totalWater = 0;

		// 0 높이부터 H - 1 높이까지 한 줄씩 조사할 예정 
		for (int y = 1; y <= H; y++) {
			int thisHeightWater = 0;
			
			// 좌측 기둥 선정
			int leftColumn = -1;
			for (int x = 0; x < W; x++) {
				if (columns[x] >= y) {
					leftColumn = x;
					break;
				}
			}

			// 우측 기둥 선정
			int rightColumn = -1;
			for (int x = W - 1; x >= 0; x--) {
				if (columns[x] >= y) {
					rightColumn = x;
					break;
				}
			}
			
//			System.out.printf("y : %d, leftColumn : %d, rightColumn : %d\n", y, leftColumn, rightColumn);

			// 양쪽 기둥 모두 존재하고, 좌측 기둥 < 우측 기둥일 경우
			if ((leftColumn != -1 && rightColumn != -1) && (leftColumn < rightColumn)) {
				// 두 기둥 사이의 x 범위 조사 
				for (int x = leftColumn + 1; x < rightColumn; x++) {
					// 해당 x칸의 높이가 y 이하라면 빗물 1칸 고임 
					if (columns[x] < y) {
						thisHeightWater++;
					}
				}
			}
			
//			System.out.println("이번 높이 빗물 : "+thisHeightWater);
			
			totalWater += thisHeightWater;

		}

		System.out.println(totalWater);
	}

}
