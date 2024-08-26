package codingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ5568 {
	static int n, k;
	static String[] numbers;
	static List<String> makedNumbers = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();

		numbers = new String[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.next();
		}

		visited = new boolean[n];
		permutation(0, "");
		
		System.out.println(makedNumbers.size());		
	}

	public static void permutation(int count, String makedNumber) {
		if (count == k) {
			if (! makedNumbers.contains(makedNumber)) {
				makedNumbers.add(makedNumber);
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {				
				visited[i] = true;
				permutation(count + 1, makedNumber + numbers[i]);
				visited[i] = false;
			}
		}
	}
}
