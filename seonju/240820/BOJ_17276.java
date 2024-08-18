import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//BOJ_17276 배열 돌리기
public class Main {
    static int[][] map;
    static int N;
    static int[][] n_map;
    static int d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            n_map = new int[N][N];  //새로 저장할 2차원 배열 -> 메모리;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    n_map[i][j] = map[i][j];
                }
            }
            if (d == 0 || d == 360) {
                print();
            }else {
                if (d < 0) {
                    d += 360;
                }
                d /= 45;  //45도로 몇번 회전

                while (d > 0) {
                    rotate();
                    d--;
                }
                print();
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(n_map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void rotate() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                n_map[i][i] = map[N / 2][i];
                n_map[i][N / 2] = map[i][i];
                n_map[N - i - 1][i] = map[N - i - 1][N / 2];
                n_map[N / 2][i] = map[N - i - 1][i];
            }
        }

        //복사 -> 낭비오짐
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = n_map[i][j];
            }
        }

    }


}