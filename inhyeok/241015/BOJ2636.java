package homework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ2636 {
	static int R, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();

		int[][] arr = new int[R][C];

		// 치즈 정보 입력
		int cheeseCount = 0;
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				int info = sc.nextInt();
				arr[y][x] = info;
				
				// 치즈 갯수 세기 
				if (info == 1) {
					cheeseCount++;
				}
				
			}
		}
		
//		System.out.println("총 치즈 : "+cheeseCount);

		// 반복하며 녹아내린 치즈 숫자
		int totalMeltCount = 0;

		// 마지막 라운드 전에 남아있던 치즈 숫자
		int lastCheeseCount = cheeseCount;
		int round = 1;
		while (true) {
			boolean[][] visited = new boolean[R][C];

			// 이번 라운드에 녹은 치즈 수, bfs는 (0, 0)에서 시작. (테두리는 무조건 빈공간이기 때문에 테두리만 탐색 가능함)
			int thisRoundCount = bfs(0, 0, arr, visited);
			
//			System.out.println(round+" 라운드 녹은 치즈 : "+thisRoundCount);

			// 지금까지 녹은 갯수 += 이번 라운드에 녹은 갯수 
			totalMeltCount += thisRoundCount;

			// 만약 치즈 다 녹으면 종료
			if (totalMeltCount == cheeseCount) {
				break;
			}

			// 마지막으로 남아있는 치즈 갯수 저장
			lastCheeseCount -= thisRoundCount;
			round++;
		}
		
		System.out.println(round);
		System.out.println(lastCheeseCount);
	}

	public static int bfs(int startX, int startY, int[][] arr, boolean[][] visited) {
		int count = 0;

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		Deque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { startX, startY });

		while (!(queue.isEmpty())) {
			int[] location = queue.pollFirst();
			int x = location[0];
			int y = location[1];
			
			visited[y][x] = true;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 맵 벗어나면 X
				if(nx < 0 || nx >= C || ny < 0 || ny >= R) {
					continue;
				}
				// 이미 방문한 공간이면 X 
				else if(visited[ny][nx] == true) {
					continue;
				}
				// 빈공간(0) 이어서 탐색 
				else if(arr[ny][nx] == 0) {
					queue.add(new int[] {nx, ny});
					visited[ny][nx] = true;
				}
				// 치즈(1)면 방문처리 후 count++
				else if(arr[ny][nx] == 1) {
					// 치즈칸 0으로 변경 
					arr[ny][nx] = 0;
					visited[ny][nx] = true;
					count++;
				}
			}
		}

		return count;
	}

}
