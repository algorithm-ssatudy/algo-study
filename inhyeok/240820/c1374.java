package codingTest;

import java.util.Arrays;
import java.util.Scanner;

public class c1374 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Lecture[] lectures = new Lecture[n];

		for (int i = 0; i < n; i++) {
			lectures[i] = new Lecture(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(lectures);
		System.out.println(Arrays.toString(lectures));
	}

	static class Lecture implements Comparable<Lecture> {

		int index, start, end;

		public Lecture(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}

		@Override
		// 종료시간 빠른 순, 같다면 시작시간이 빠른
		public int compareTo(Lecture o) {
//			return this.end != o.end ? this.end - o.end : this.start - o.start;
			return this.start != o.start ? this.start - o.start : this.end - o.end;
		}

		@Override
		public String toString() {
			return "Lecture [index=" + index + ", start=" + start + ", end=" + end + "]\n";
		}

		
	}
}
