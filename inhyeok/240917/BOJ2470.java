package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
	static int N;
	static int[] liquid;
	static int bestMix;
	static int bestLow, bestHigh;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		liquid = new int[N];

		// 용액 N개 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(liquid);

		// (초기값) 0번째 + 1번째 
		int firstMix = liquid[0] + liquid[1];	
		bestMix = firstMix;
		bestLow = liquid[0];
		bestHigh = liquid[1];

		// 1개 선택 (i)
		for (int i = 0; i < N - 1; i++) {
			// 나머지 1개는 이분탐색으로 선택 (i + 1  ~  N - 1)
			binarySearch(i + 1, N - 1, liquid[i]);
		}

		System.out.println(bestLow + " " + bestHigh);
	}

	static void binarySearch(int start, int end, int currentValue) {
		if (start > end) {
			return;
		}

		int mid = (start + end) / 2;
		int mixResult = currentValue + liquid[mid];

		// 섞은게 더 0에 가까우면 갱신
		if (Math.abs(mixResult) < Math.abs(bestMix)) {
			bestMix = mixResult;
			bestLow = Math.min(currentValue, liquid[mid]);
			bestHigh = Math.max(currentValue, liquid[mid]);
		}

		if (mixResult == 0) {
			return;
		}
		else if (mixResult > 0) {
			binarySearch(start, mid - 1, currentValue);
			return;
		} else {
			binarySearch(mid + 1, end, currentValue);
			return;
		}
	}
}
