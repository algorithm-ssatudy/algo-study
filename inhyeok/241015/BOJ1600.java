package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1600 {
	static int K, W, H;
	static int[][] map;
	static int[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] horse = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 2, -1 }, { 2, 1 }, { 1, -2 }, { 1, 2 } };
	static int minMoveCount = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				int info = Integer.parseInt(st.nextToken());
				map[i][j] = info;
			}
		}
		// 3차원 방문체크 배열 (y행 x열에 i번의 점프로 방문함)
		visited = new int[H][W][K + 1];
		visited[0][0][0] = 1;
		int moveCount = bfs();

		System.out.println(moveCount);
	}

	static int bfs() {
		// x, y, 점프횟수
		Deque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { 0, 0, 0 });

		while (!queue.isEmpty()) {
			int[] info = queue.pollFirst();
			int x = info[0];
			int y = info[1];
			int jumpCount = info[2];
//			System.out.printf("(%d, %d), 점프 %d회\n", x, y, jumpCount);
			
			if (x == W - 1 && y == H - 1) {
				return visited[y][x][jumpCount] - 1;
			}

			// case1. 일반적인 움직임
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= W || ny < 0 || ny >= H) {
					continue;
				}
				// 지금의 점프 횟수로 아직 방문하지 않은 곳 && 장애물이 없다면 
				else if (visited[ny][nx][jumpCount] == 0 && map[ny][nx] == 0) {
					// 지금의 점프 횟수로 방문체크, queue 추가 
					visited[ny][nx][jumpCount] = visited[y][x][jumpCount] + 1;
					queue.add(new int[] {nx, ny, jumpCount});
				}
			}

			// case2. 말처럼 움직임
			if (jumpCount < K) {
				for(int[] delta : horse) {
					int nx = x + delta[0];
					int ny = y + delta[1];
					
					if (nx < 0 || nx >= W || ny < 0 || ny >= H) {
						continue;
					}
					// 지금의 점프 횟수 +1로 아직 방문하지 않은 곳 && 장애물이 없다면 
					else if (visited[ny][nx][jumpCount + 1] == 0 && map[ny][nx] == 0) {
						// 지금의 점프 횟수 +1로 방문체크, queue 추가 
						visited[ny][nx][jumpCount + 1] = visited[y][x][jumpCount] + 1;
						queue.add(new int[] {nx, ny, jumpCount + 1});
					}
				}
			}
		}
		
		return -1;
	}
}
