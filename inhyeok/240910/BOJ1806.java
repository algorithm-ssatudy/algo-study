package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 수열 길이
		int N = Integer.parseInt(st.nextToken());

		// 목표 값
		int target = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		// 수열
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = arr[0];
		int minLength = Integer.MAX_VALUE;

		while (true) {
			if (end == N) {
				break;
			}

			int length = end - start + 1;
			// 목표 값보다 크고
			if (sum >= target) {
				// 이번 길이가 가장 짧다면 갱신
				if (minLength > length) {
					minLength = length;
					if (minLength == 1) {
						break;
					}
				}
				
				sum -= arr[start];
				start++;
			}		
			// 목표 값보다 작으면 무조건 end++
			else {
				end++;
				if (end < N) {
					sum += arr[end];
				}
				
			}
		}

		System.out.println(minLength != Integer.MAX_VALUE ? minLength : 0);
	}

}
