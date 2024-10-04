package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1194 {
	static int N, M;
	static char[][] map;
	static int[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int startX = 0, startY = 0;

		// N x M 사이즈 맵 정보 입력
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				char info = line.charAt(j);
				map[i][j] = info;

				// 시작지점 위치 저장, '0'대신 '.'으로 저장 
				if (info == '0') {
					startX = j;
					startY = i;
					map[i][j] = '.';
				}
			}
		}

		// N행 M열에 bitmask 키정보를 갖고 몇번의 이동만에 도착했는지 저장
		visited = new int[N][M][1 << 6];
		visited[startY][startX][0] = 1;

		int result = bfs(startX, startY);
		System.out.println(result);
	}

	static int bfs(int startX, int startY) {
		Deque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { startX, startY, 0 });

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			int[] info = queue.pollFirst();
			int x = info[0];
			int y = info[1];
			int keys = info[2];


			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				
				// 맵 벗어나면 X
				if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
					continue;
				}
				// 벽 만나면 X
				else if (map[ny][nx] == '#') {
					continue;
				}
				// 1. 빈칸 
				else if (map[ny][nx] == '.') {
					// 지금 key 정보로 아직 미방문한 경우에만 이동 
					if (visited[ny][nx][keys] == 0) {
						visited[ny][nx][keys] = visited[y][x][keys] + 1;
//						System.out.printf("빈칸 (%d, %d) 새로운 키 : %d\n", nx, ny, keys);
						queue.add(new int[] {nx, ny, keys});
					}
				}
				// 2. 열쇠칸
				else if (map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
					// 새로운 키 비트마스킹으로 추가 
					int keyIndex = map[ny][nx] - 'a';
					int newKeys = keys | (1 << keyIndex);
					
					// 새로운 key 정보로 아직 미방문한 경우에만 이동 
					if (visited[ny][nx][newKeys] == 0) {
						visited[ny][nx][newKeys] = visited[y][x][keys] + 1;
//						System.out.printf("열쇠칸 (%d, %d) 새로운 키 : %d\n", nx, ny, newKeys);
						queue.add(new int[] {nx, ny, newKeys});
					}
				}
				// 3. 문 
				else if (map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
					// 예) 해당 칸이 'B'인 경우 doorIndex = 1 << 1
					int doorIndex = 1 << (map[ny][nx] - 'A');
					
					// 예) keys가 000010인 경우, 10 & 000010
					if ((doorIndex & keys) == doorIndex) {
						int newKeys = keys | doorIndex;
						// 새로운 key 정보로 아직 미방문한 경우에만 이동 
						if (visited[ny][nx][newKeys] == 0) {
							visited[ny][nx][newKeys] = visited[y][x][keys] + 1;
//							System.out.printf("문칸 (%d, %d) 새로운 키 : %d\n", nx, ny, newKeys);
							queue.add(new int[] {nx, ny, newKeys});
						}						
					}
				}
				// 4. 탈출구 '1'
				else if (map[ny][nx] == '1') {
					return visited[y][x][keys];
				}
			}
		}

		// 탈출 불가 시 -1 리턴
		return -1;
	}
}
