package homework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ3055 {
	static int R, C;
	static char[][] forest;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int exitTime = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		// C x R 사이즈 숲
		forest = new char[R][C];

		// 비버 굴 좌표 (x, y)
		int[] safeZone = new int[2];
		// 고슴도치 좌표 (x, y)
		int[] animal = new int[2];

		// 물 (x, y)
		Deque<int[]> waterQueue = new ArrayDeque<int[]>();

		// 숲 정보 입력
		for (int i = 0; i < R; i++) {
			String line = sc.next();
			for (int j = 0; j < C; j++) {
				char info = line.charAt(j);
//				System.out.println("info : "+info);

				// 비버의 굴, 고슴도치, 물은 좌표 정보도 입력해 둠
				if (info == 'D') {
					safeZone[0] = j;
					safeZone[1] = i;
				} else if (info == 'S') {
					animal[0] = j;
					animal[1] = i;
				} else if (info == '*') {
					waterQueue.add(new int[] { j, i });
				}

				forest[i][j] = info;
			}
		}

		// 숲 전역에 물 차오르며 고슴도치 탈출 시작
		bfs(waterQueue, animal);

		// 탈출 시간 출력
		System.out.println(exitTime != -1 ? exitTime : "KAKTUS");
	}

	public static void bfs(Deque<int[]> waterQueue, int[] animal) {
		Deque<int[]> animalQueue = new ArrayDeque<int[]>();
		animalQueue.add(new int[] { animal[0], animal[1], 0 });

		while (!animalQueue.isEmpty()) {

			// 1. 물 퍼뜨림
			int waterSize = waterQueue.size();
			for (int i = 0; i < waterSize; i++) {
				int[] waterInfo = waterQueue.pollFirst();
				int x = waterInfo[0];
				int y = waterInfo[1];

				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					// 맵 벗어나면 X
					if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
						continue;
					}
					// 빈 공간에 물 채우기
					else if (forest[ny][nx] == '.') {
						forest[ny][nx] = '*';
						waterQueue.add(new int[] { nx, ny });
					}
				}
			}

			// 2. 고슴도치 이동
			int animalSize = animalQueue.size();
			for (int i = 0; i < animalSize; i++) {
				int[] animalInfo = animalQueue.pollFirst();
				int x = animalInfo[0];
				int y = animalInfo[1];
				int time = animalInfo[2];

				for (int j = 0; j < 4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];

					// 맵 벗어나면 X
					if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
						continue;
					}
					// 비버의 굴(D)이면 다음턴에 종료
					if (forest[ny][nx] == 'D') {
						exitTime = time + 1;
						return;
					}
					// 돌(X)이면 못 감
					else if (forest[ny][nx] == 'X') {
						continue;
					}
					// 빈공간(.)으로 남아있으면 이동 가능
					else if (forest[ny][nx] == '.') {
						forest[ny][nx] = 'S';
						animalQueue.add(new int[] { nx, ny, time + 1 });
					}
				}
			}

		}
	}

}
