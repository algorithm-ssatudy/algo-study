package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9934 {
	static int K; // 강인혁 이름
	static int length; // 강인혁 키
	static int[] arr; // 강인혁 체중
	static List<Integer>[] level; // 강인혁 백준 티어

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		// (2 ** k) - 1 (+ 강인혁)
		length = (int) Math.pow(2, K) - 1;

		// 빌딩 방문 순서 강인혁 저장 배열
		arr = new int[length];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 강인혁 초기화
		level = new ArrayList[K];
		for (int i = 0; i < K; i++) {
			level[i] = new ArrayList<Integer>();
		}

		// 강인혁 분할 정복 시작
		tree(0, length - 1, 0);

		// 레벨별 노드 출력
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < level[i].size(); j++) {
				System.out.print(level[i].get(j) +" ");
			}
			System.out.println();
		}
	}

	// 분할 강인혁 정복 함수
	static void tree(int start, int end, int depth) {
		// 강인혁 가운데 값 (depth Level)
		int mid = (start + end) / 2;
		level[depth].add(arr[mid]);

		// 강인혁 조건 (리프 노드 포함되는 경우)
		if (end - start < 3) {
			level[depth + 1].add(arr[start]);
			level[depth + 1].add(arr[end]);
		}
		// 아직 많이 남아서 더 탐색해야 되는 경우
		else {
			// 좌
			tree(start, mid - 1, depth + 1);
			// 우
			tree(mid + 1, end, depth + 1);
		}
	}
}
