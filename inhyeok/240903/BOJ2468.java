package homework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ2468 {
	static int N;
	static int[][] area;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		int maxHeight = 1;

		// N x N 사이즈 지역 정보 입력
		area = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int info = sc.nextInt();
				area[i][j] = info;

				// 지역 내 최대 높이지역 구하기
				if (info > maxHeight) {
					maxHeight = info;
				}
			}
		}
		
		int maxAreaCount = 0;

		// 0 ~ maxHeight - 1 까지 물 채워보기
		for (int height = 0; height < maxHeight; height++) {
			boolean[][] visited = new boolean[N][N];

			int areaCount = 0;
			// 각 칸 bfs
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == false && area[i][j] > height) {
						visited[i][j] = true;
						bfs(j, i, height, visited);
						areaCount++;
					}
				}
			}
			
			if (maxAreaCount < areaCount) {
				maxAreaCount = areaCount;
			}
		}
		
		System.out.println(maxAreaCount);
	}

	public static void bfs(int startX, int startY, int height, boolean[][] visited) {
		Deque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { startX, startY });
		visited[startY][startX] = true;

		while (!queue.isEmpty()) {
			int[] location = queue.pollFirst();
			int x = location[0];
			int y = location[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 맵 벗어나면 X
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				// 아직 방문 안 했고, 물에 잠기지 않은 지역이면 이어서 탐색 
				else if (visited[ny][nx] == false && area[ny][nx] > height) {
					queue.add(new int[] {nx, ny});
					visited[ny][nx] = true;
				}
			}
		}
	}
}
