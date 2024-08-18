package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ_1446 지름길
public class  Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dp = new int[D + 1]; // dp
        int[][] map = new int[N][3]; // 지름길 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
        for (int i = 0; i <= D; i++) { // 값 초기화
            dp[i] = i;
        }

        for (int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1); // 이전 값과 비교 후 갱신
            for (int j = 0; j < N; j++) { // 지름길 갱신
                if (map[j][1] == i)
                    dp[i] = Math.min(dp[i], dp[map[j][0]] + map[j][2]); // 최솟값 갱신
            }
        }

//		for (int i = 0; i <= D; i++) {
//			System.out.print(dp[i] + " ");
//		}
        System.out.println(dp[D]); // 도착지점이 최댓값
    }
}
