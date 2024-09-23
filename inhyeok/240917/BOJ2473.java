package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473 {
	static int N;
	static long[] liquid;
	static long bestMix;
	static long bestLow, bestMid, bestHigh;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		liquid = new long[N];

		// 용액 N개 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(liquid);
		
		bestMix = Math.abs(liquid[0] + liquid[1] + liquid[2]);
		bestLow = liquid[0];
		bestMid = liquid[1];
		bestHigh = liquid[2];

		// 1개 고정 (i)
		for (int i = 0; i < N - 2; i++) {
			// 나머지 2개는 투 포인터로 선택 (i + 1  ~ N - 1)
			twoPointer(i, i + 1, N - 1);
		}

		System.out.println(bestLow + " " + bestMid + " " + bestHigh);
	}

	static void twoPointer(int fixed, int start, int end) {
		if (start >= end) {
			return;
		}
		
		long sum = liquid[fixed] + liquid[start] + liquid[end];
		
		// 최소값 발견 시 갱신 
		if (bestMix > Math.abs(sum)) {
			bestMix = Math.abs(sum);
			bestLow = liquid[fixed];
			bestMid = liquid[start];
			bestHigh = liquid[end];
		}

		if (sum == 0) {
			return;
		} else if (sum > 0) {
			twoPointer(fixed, start, end - 1);
		} else {
			twoPointer(fixed, start + 1, end);
		}

	}
}
