package codingTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ1113 {
	static int N, M;
	static int[][] pool;	
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		// 가장 높은 수영장 부분
		int maxHeight = 1;

		// 수영장 이차원배열에 입력받기
		pool = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				// 수영장 정보 입력
				int info = line.charAt(j) - '0';
				pool[i][j] = info;

				// 가장 높았던 높이 저장하기
				if (maxHeight < info) {
					maxHeight = info;
				}
			}
		}

		int totalAddedWater = 0;

		// 2 ~ maxHeight까지 BFS로 물채우기
		for (int height = 2; height <= maxHeight; height++) {			

			// 물 채우기 BFS
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					if (pool[i][j] < height) {
						totalAddedWater += bfsPool(j, i, height);
					}
				}
			}
		}

		System.out.println(totalAddedWater);
	}


	// 정상적으로 물 채울 수 있는 영역들 BFS
	public static int bfsPool(int startX, int startY, int height) {
		int additionalWater = 0;
		boolean outOfPool = false;

		Deque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { startX, startY });

		while (!(queue.isEmpty())) {
			int[] location = queue.pollFirst();
			int x = location[0];
			int y = location[1];
			
			if (pool[y][x] < height) {
				// 이번에 뽑은 공간 물 1칸 추가 예정
				pool[y][x] = height;
				additionalWater++;

				// bfs 
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					// 맵 벗어나면 X 
					if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
						outOfPool = true;
						continue;
					}
					// height == 2라면, 아직 1로 채워진 부분일 경우만.
					else if (pool[ny][nx] < height) {
						// 큐에 이어서 탐색할 좌표 추가
						queue.add(new int[] { nx, ny });
					}
				}
			}

		}
		
		// 수영장 밖으로 물이 탈출해 버리는 경우일 땐 additionalWater == 0을 반환함 
		if (outOfPool == true) {
			additionalWater = 0;
		}

		return additionalWater;
	}
}
