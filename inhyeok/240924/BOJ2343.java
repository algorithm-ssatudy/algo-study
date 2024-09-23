package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2343 {
	static int N, M;
	static int[] lessons;
	static int bestSize = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 강의 수 N, 블루레이 수 M
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// N개의 강의 시간들 저장
		st = new StringTokenizer(br.readLine());
		lessons = new int[N];
		for (int i = 0; i < N; i++) {
			lessons[i] = Integer.parseInt(st.nextToken());
		}

		// 이분 탐색 시작
		binarySearch(1, 10000 * 100000);

		// 결과
		System.out.println(bestSize);
	}

	static void binarySearch(int start, int end) {
		if (start > end) {
			return;
		}

		int mid = (start + end) / 2;

		int overCount = 0;
		int minuteSum = 0;
		for (int i = 0; i < N; i++) {
			minuteSum += lessons[i];

			if (minuteSum > mid) {
				overCount++;
				minuteSum = 0;
				i -= 1;
			}

			// 디스크 용량을 더 키워서 탐색
			if (overCount >= M) {
				binarySearch(mid + 1, end);
				return;
			}
		}

		// 디스크 용량 더 줄여서도 가능한가 해보기
		if (bestSize > mid) {
			bestSize = mid;
			binarySearch(start, mid - 1);
		}
		

	}
}
