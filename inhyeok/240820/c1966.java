package codingTest;

import java.util.Arrays;
import java.util.Scanner;

public class c1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int round = 1; round <= T; round++) {
			int n = sc.nextInt();
			int target = sc.nextInt();

			// 프린터 큐
			int[] queue = new int[n];
			int head = 0;

			// 중요도 큐
			int[] priority = new int[n];

			// 문서 입력
			for (int i = 0; i < n; i++) {
				int num = sc.nextInt();
				queue[i] = num;
				priority[i] = num;
			}

			// 중요도 순서로 정렬 (오름차순)
			Arrays.sort(priority);
			int headPriority = n - 1; // 우선순위 저장해둔 배열 맨 뒤에서부터 확인 예정 
			
			boolean targetIsPrinted = false;

			// n개의 문서 대상으로 for문 
			for (int i = 0; i < n; i++) {
				// head에 가장 우선순위가 큰 문서가 걸릴 때까지 
				while(true) {
					// 1. 가장 우선순위 큰 문서여야 하고, 2. 이미 출력된 문서 (-1)가 아니어야 함 
					if ((queue[head % n] == priority[headPriority]) && queue[head % n] != -1) {				
						// 이번에 출력할 문서가 target번째면 탐색 완료 (targetIsPrinted = true;)
						if (head % n == target) {
							targetIsPrinted = true;
						}
						queue[head % n] = -1;
						headPriority--;
						break;
					}
					head++;
				}
				
				if (targetIsPrinted) {
					System.out.println(i + 1);
					break;
				}
			}
		}
	}

}
