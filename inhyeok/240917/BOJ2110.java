package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
	static int N, C;
	static int[] ap;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		ap = new int[N];
		for (int i = 0; i < N; i++) {
			ap[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(ap);
		binarySearch(1, ap[N - 1] - ap[0] + 1);

		System.out.println(result);
	}

	static void binarySearch(int start, int end) {
		if (start >= end) {
			return;
		}
//		System.out.println("binarySearch, start : "+start+", end : "+end);
		int length = (start + end) / 2;

		int apCnt = 1;
		int prevIndex = 0;
		for (int i = 1; i < N; i++) {
			// 지정한 최소거리(length)보다 집 사이 거리가 더 커야 설치함 
			if (ap[i] - ap[prevIndex] >= length) {				
				apCnt++;
//				System.out.printf("i : %d, prevIndex : %d, apCnt : %d\n", i, prevIndex, apCnt);
				prevIndex = i;
				
				// 성공적으로 C개 설치하면 length 더 크게해보고 되나 보기 
				if (apCnt == C) {
					binarySearch(length + 1, end);
					if (result < length) {
						result = length;
					}
					return;
				}
			}
		}
		
		// 공유기 C개 설치 못했다면 length 더 줄여서 탐색 다시 시도 
		if (apCnt < C) {
			binarySearch(start, length);			
			return;
		}
	}
}
