import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//BOJ_16395 파스칼의 삼각형
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[R + W + 1][R + W + 1];
        map[1][1] = 1;  //첫 시작
        int count = 1;
        int sum = 0;
        for (int i = 2; i < R + W; i++) {   //map 값 채우기
            for (int j = 1; j <= i; j++) {   //[2][1]부터 시작
                if (j == 1) {
                    map[i][j] = 1;  //첫번째 값은 1
                }
                map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
            }
        }
        for (int i = R; i < W + R; i++) {   //3~6까지
            for (int j = C; j < C + count; j++) {
                sum += map[i][j];
            }
            count += 1;
        }
        System.out.println(sum);
    }
}


