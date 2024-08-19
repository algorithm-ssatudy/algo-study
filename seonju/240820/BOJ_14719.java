import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ_14719 빗물
public class BOJ_14719 {
    static int[] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        int drop = 0;
        building = new int[W];    //가로길이만큼
        //건물 높이
        for (int i = 0; i < W; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < W - 1; i++) {   //양쪽 끝은 확인할 필요 x
            int l_height = 0;
            int r_height = 0;
            if (building[i] == H) continue;  //현재 높이가 최대면 확인할 필요 없음
            for (int j = i - 1; j >= 0; j--) {  //왼쪽 확인
                l_height = Math.max(l_height, building[j]); //왼쪽 높이 중 최대
            }
            for (int j = i + 1; j < W; j++) {
                r_height = Math.max(r_height, building[j]); //오른쪽 높이 중 최대
            }
            int height = Math.min(l_height, r_height);  //두 높이 중 최소
            int result = height - building[i];
            result = Math.max(result,0);    //음수인 경우 더하지 않도록 해야함
            drop += result;    //빗물 총량

        }
        drop = Math.max(drop, 0);
        System.out.println(drop);
    }
}
