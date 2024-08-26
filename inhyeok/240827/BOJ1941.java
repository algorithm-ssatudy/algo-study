package codingTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ1941 {
	static char[][] classroom = new char[5][5];
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			String line = sc.next();
			for (int j = 0; j < 5; j++) {
				char student = line.charAt(j);
				classroom[i][j] = student;
			}
		}

		backTracking(0, 0, 0, 0, new int[7]);
		System.out.println(result);
	}

	public static void backTracking(int index, int count, int Y, int S, int[] selected) {
		if (count == 7) {
//			System.out.printf("Y : %d, S : %d\n", Y, S);
			
			boolean checkResult = bfs(selected);

			if (checkResult == true) {
//				System.out.println(Arrays.toString(selected));
				result++;
			}
			return;
		}

		for (int i = index; i < 25; i++) {
			int y = i / 5;
			int x = i % 5;

			char student = classroom[y][x];
			switch (student) {
			case 'Y':
				if (Y < 3) {
					selected[count] = i;
					backTracking(i + 1, count + 1, Y + 1, S, selected);
				}
				break;
			case 'S':
				selected[count] = i;
				backTracking(i + 1, count + 1, Y, S + 1, selected);
				break;
			}
		}
	}

	public static boolean bfs(int[] selected) {
		boolean result = false;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// 7명의 학생 배치를 저장할 2차원 배열
		boolean[][] selectedMap = new boolean[5][5];

		// 5 x 5 배열에 학생 7명 자리 저장
		for (int number : selected) {
			int y = number / 5;
			int x = number % 5;

			selectedMap[y][x] = true;
		}

		int number = selected[0];
		int y = number / 5;
		int x = number % 5;

		// 7명이 이어져 있는지 확인
		int count = 0;
		Deque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] { x, y });
		
		boolean[][] visited = new boolean[5][5];

		while (!(queue.isEmpty())) {
			int[] location = queue.pollFirst();
			x = location[0];
			y = location[1];
			
//			System.out.printf("bfs 큐에서 꺼낸좌표 (%d, %d), count : %d\n", x, y, count);

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
					continue;
				} else if (selectedMap[ny][nx] == true) {
					queue.add(new int[] {nx, ny});
					selectedMap[ny][nx] = false;
					count++;
				}
			}
		}
		
		// 만약 7명이 다닥다닥 붙어있다면 true 
		if (count == 7) {
			result = true;
		}

		return result;
	}
}
