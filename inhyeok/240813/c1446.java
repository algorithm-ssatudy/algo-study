package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class c1446 {
	static int finishLine = 0;
	static int minDistance = Integer.MAX_VALUE;
//	static List<List<Integer[]>> graph = new ArrayList<List<Integer[]>>();
	static List<Integer[]> fastRoads = new ArrayList<Integer[]>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		finishLine = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int cost = sc.nextInt();

			// 도착지점이 고속도로 밖으로 넘어가면 사용 안 함
			if (end > finishLine) {
				continue;
			}

			// 지름길을 사용하는게 오히려 더 오래걸리는 경우 사용 안 함
			if (cost > (end - start)) {
				continue;
			}

			fastRoads.add(new Integer[] { start, end, cost });

		}

		Collections.sort(fastRoads, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] arr1, Integer[] arr2) {
				return arr1[0].compareTo(arr2[0]);
			}
		});

//		for (Integer[] arr : fastRoads) {
//			System.out.println(Arrays.toString(arr));
//		}

		backTracking(0, 0, 0);
		System.out.println(minDistance);
	}

	public static void backTracking(int index, int currentLocation, int totalDistance) {
		if (index == fastRoads.size()) {
			totalDistance = totalDistance + (finishLine - currentLocation);
			minDistance = Math.min(minDistance, totalDistance);
			return;
		}

		for (int i = index; i < fastRoads.size(); i++) {
			Integer[] fastRoad = fastRoads.get(i);
			// 지름길 이용 로직 
			if (fastRoad[0] >= currentLocation) {
				
				int distance = totalDistance;
				// 지름길 시작점까진 그냥 이동 
				distance += (fastRoad[0] - currentLocation);

				// 지름길 이용 후 cost만큼 거리 추가 
				distance += fastRoad[2];

				// 다음 지름길 찾아서 백트래킹 
				backTracking(i + 1, fastRoad[1], distance);
			}
		}
		
		// 지름길 이용 못한 경우 있을 수 있으니 
		backTracking(fastRoads.size(), currentLocation, totalDistance);
	}

}
