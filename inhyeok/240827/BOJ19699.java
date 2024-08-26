package codingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ19699 {
	static int N, M;
	static int[] numbers;
	static List<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}

		combinations(0, 0, 0);

		if (primes.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(primes);
			for (int i = 0; i < primes.size(); i++) {
				System.out.print(primes.get(i) + " ");
			}
		}

	}

	public static void combinations(int index, int count, int sum) {
		if (count == M) {
			if (isPrime(sum) == true && !(primes.contains(sum))) {
				primes.add(sum);
			}
			return;
		}

		for (int i = index; i < N; i++) {
			combinations(i + 1, count + 1, sum + numbers[i]);
		}
	}

	public static boolean isPrime(int number) {
		boolean result = true;

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return result;
	}
}
