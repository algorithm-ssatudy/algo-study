package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class c2565 {
	static int n;
	static List<Integer[]> lines = new ArrayList<Integer[]>();
	static int maxLines = 0;
	static List<Boolean> isUsed = new ArrayList<Boolean>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			lines.add(new Integer[] { start, end });
		}

		Collections.sort(lines, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {

				return o1[0].compareTo(o2[0]);
			}

		});

//		for (int i = 0; i < n; i++) {
//			System.out.println("line : " + lines.get(i)[0] + ", " + lines.get(i)[1]);
//		}

		
		int[] dp = new int[n];
		int maxLines = 0;
		
		Arrays.fill(dp, 1);
		for(int i=1 ; i<n ; i++) {
			int endCurrent = lines.get(i)[1];
			
			for(int j=0 ; j<i ; j++) {
				int endPrevious = lines.get(j)[1];
				if (endCurrent > endPrevious) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					maxLines = Math.max(maxLines, dp[i]);
				}
			}
		}
	
		
		System.out.println(n - maxLines);
	}

}
