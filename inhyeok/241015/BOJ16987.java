package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16987 {
	static int N;
	static int[] hp;
	static int[] weight;
	static int maxDestroyed = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		hp = new int[N];
		weight = new int[N];

		// N개의 계란 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			hp[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}

		destroyEgg(0, 0);
		System.out.println(maxDestroyed);
	}

	static void destroyEgg(int count, int destroyCount) {
		if (count == N) {
			if (maxDestroyed < destroyCount) {
				maxDestroyed = destroyCount;
			}
			return;
		}
		
		// 만약 count번째 계란이 이미 부숴져있으면 다음 단계로 진행 
		if (hp[count] <= 0) {
			destroyEgg(count + 1, destroyCount);
			return;
		}

		int tryCount = 0;
		for (int i = 0; i < N; i++) {
			// 내려칠 대상(i)이 현재 쥐고있는 계란(count)이 아니고 대상(i)의 HP가 0 이상이면 시도 
			if ((i != count) && (hp[i] > 0)) {
				tryCount++;
				
				// 쥐고있는 계란 내구도 감소 
				hp[count] -= weight[i];
				
				// 내려친 계란 내구도 감소 
				hp[i] -= weight[count];
//				System.out.printf("%d계란으로 %d계란 내려침, hp : %s\n", count, i, Arrays.toString(hp));
				// 부숴진 계란 카운트 증가 
				int newlyDestroyed = 0;
				
				if (hp[count] <= 0) {
					newlyDestroyed++;
				}
				if (hp[i] <= 0) {
					newlyDestroyed++;
				}
//				System.out.println("newlyDestroyed : "+newlyDestroyed);
				destroyEgg(count + 1, destroyCount + newlyDestroyed);
				
				// 원상 복구 
				hp[count] += weight[i];
				hp[i] += weight[count];
			}
		}
		
		// 계란 내려치기를 시도할 대상이 없이 다 깨져있다면 종료 
		if (tryCount == 0) {
			destroyEgg(N, destroyCount);
		}
	}
}
