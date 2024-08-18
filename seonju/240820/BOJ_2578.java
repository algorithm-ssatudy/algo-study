import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//BOJ_2578 빙고
public class Main {
    static int[][] bingo;
    static int b_count;
    static StringTokenizer st;
    static BufferedReader br;
    static int count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[5][5];
        for (int i = 0; i < 5; i++) {   //빙고판 저장
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        b_count = 0;
        count = 0;
        for(int t = 0; t<5; t++) {   //빙고확인
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < 5; i++) {
                int num = Integer.parseInt(st.nextToken());
                for (int j = 0; j < 5; j++) {
                    for (int l = 0; l < 5; l++) {
                        if (bingo[j][l] == num) {   //부른 번호가 빙고판에 있으면
                            b_count++;
                            bingo[j][l] = 0;    //0으로 변경
                        }
                    }
                }

                h_check();
                v_check();
                lc_check();
                rc_check();

                if (count >= 3) {
                    System.out.println(b_count);
                    return;
                }
                count = 0;

            }
        }
    }

    public static void h_check() {
        int b_count = 0;
        for (int i = 0; i < 5; i++) { //가로 확인
            b_count = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0) {
                    b_count++;
                }
                if (b_count == 5) {
                    count++;
                }
            }
        }
    }

    public static void v_check() {
        int b_count = 0;
        for (int j = 0; j < 5; j++) {   //세로 확인
            b_count = 0;
            for (int i = 0; i < 5; i++) {
                if (bingo[i][j] == 0) {
                    b_count++;
                }
                if (b_count == 5) {
                    count++;
                }
            }
        }
    }

    public static void lc_check() {  //왼쪽 대각선
        int b_count = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) {
                b_count++;
            }
            if (b_count == 5) {
                count++;
            }
        }
    }

    public static void rc_check() {  //오른쪽 대각선
        int b_count = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == 0) {
                b_count++;
            }
            if (b_count == 5) {
                count++;
            }
        }
    }

}