package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1713 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 사진틀 칸 수
		int N = Integer.parseInt(br.readLine());

		// 추천 횟수
		int M = Integer.parseInt(br.readLine());

		// 사진틀에 올라갔는지 확인 true/false
		boolean[] onPictureBoard = new boolean[101];

		// 학생별 추천 수
		int[] recommendations = new int[101];

		// 학생별 최초 등록 시각
		int[] registeredTime = new int[101];

		// 현재 사진틀에 올라간 학생 수
		int registerCount = 0;

		// 1명씩 추천
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int student = Integer.parseInt(st.nextToken());

			// 1. 사진틀이 꽉 찼다면 사진 교체
			if (registerCount == N) {
				// 1.1. 이미 올라가 있던 학생이라면
				if (onPictureBoard[student] == true) {
					recommendations[student]++;
				}
				// 1.2. 아니라면
				else {
					// int[] {학생 번호, 추천 수, 최초 등록 시각}
					PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {
						// 만약 추천 수가 같다면 등록 시각 먼저인 학생 제거
						if (o1[1] == o2[1]) {
							return Integer.compare(o1[2], o2[2]);
						}

						// 추천 수 가장 적은 학생 제거
						return Integer.compare(o1[1], o2[1]);
					});

					// 우선순위큐에 등록된 학생 N명 추가
					int count = 0;
					int index = 0;
					while (count < N && index <= 100) {
						if (onPictureBoard[index] == true) {
							pq.add(new int[] { index, recommendations[index], registeredTime[index] });
							count++;
						}

						index++;
					}

					// 우선순위 가장 빠른 (추천수 젤 낮고, 추천 수 같다면 젤 먼저 등록된) 학생 제거 
					int[] removedInfo = pq.poll();
					int studentIndex = removedInfo[0];

					onPictureBoard[studentIndex] = false;
					recommendations[studentIndex] = 0;
					registeredTime[studentIndex] = 0;
					
					// 새로운 학생 등록 
					onPictureBoard[student] = true;
					recommendations[student] = 1;
					registeredTime[student] = i;
				}

			}
			// 2. 사진틀에 여유 공간이 있다면 그냥 추가
			else {
				// 2.1. 이미 올라가 있던 학생이라면
				if (onPictureBoard[student] == true) {
					recommendations[student]++;
				}
				// 2.2. 새로 등록되는 학생이라면
				else {
					onPictureBoard[student] = true;
					recommendations[student] = 1;
					registeredTime[student] = i;

					registerCount++;
				}
			}
		}

		int count = 0;
		int index = 0;
		while (count < N && index <= 100) {
			if (onPictureBoard[index] == true) {
				System.out.print(index + " ");
				count++;
			}

			index++;
		}
	}

}
