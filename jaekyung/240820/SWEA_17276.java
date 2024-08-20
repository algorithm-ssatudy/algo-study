

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_17276 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // d가 0도, 360도 또는 -360도인 경우 회전 없이 바로 출력
            if (d == 0 || d == 360 || d == -360) {
                // 배열 출력
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
                continue;  // 다음 테스트 케이스로
            }

            // 회전 횟수 계산
            int rotations = Math.abs(d) / 45;
            boolean clockwise = d > 0;  // 양수면 시계방향, 음수면 반시계방향

            // 주어진 각도에 맞게 여러 번 회전
            for (int r = 0; r < rotations; r++) {
                int[] aDia = new int[n];  // 주 대각선
                int[] col = new int[n];   // 중앙 열
                int[] naDia = new int[n]; // 부 대각선
                int[] row = new int[n];   // 중앙 행

                // 대각선, 중앙 행/열 값 추출
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j) aDia[i] = arr[i][j];         // 주 대각선
                        if (j == n / 2) col[i] = arr[i][j];       // 중앙 열
                        if (i + j == n - 1) naDia[i] = arr[i][j]; // 부 대각선
                        if (i == n / 2) row[j] = arr[i][j];       // 중앙 행
                    }
                }

                // 시계방향으로 회전
                if (clockwise) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i == j) arr[i][j] = row[j];             // 주 대각선 <- 중앙 행
                            if (j == n / 2) arr[i][j] = aDia[i];        // 중앙 열 <- 주 대각선
                            if (i + j == n - 1) arr[i][j] = col[i];     // 부 대각선 <- 중앙 열
                            if (i == n / 2) arr[i][j] = naDia[n - j - 1]; // 중앙 행 <- 부 대각선
                        }
                    }
                }
                // 반시계방향으로 회전
                else {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i == j) arr[i][j] = col[i];            // 주 대각선 <- 중앙 열
                            if (j == n / 2) arr[i][j] = naDia[i];      // 중앙 열 <- 부 대각선
                            if (i + j == n - 1) arr[i][j] = row[n - i - 1]; // 부 대각선 <- 중앙 행
                            if (i == n / 2) arr[i][j] = aDia[j];       // 중앙 행 <- 주 대각선
                        }
                    }
                }
            }

            // 회전 후 배열 출력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
