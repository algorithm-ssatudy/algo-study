import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

//BOJ_11055 가장 큰 증가하는 부분 수열
public class BOJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int max_val = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {   //자료 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {   //dp 값 채워넣기
            dp[i] = arr[i]; //본인 dp 값 업데이트
            for (int j = 0; j < i; j++) {   //이전값 확인
                if (arr[i] > arr[j]) {  //더 큰 값일 때
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);    //값 갱신
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dp[i] > max_val) {
                max_val = dp[i];
            }
        }
        System.out.println(max_val);
    }
}


