import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//BOJ_1966 강의실
public class Main {

    static int max_count;
    static int N;
    static List<int[]> arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new int[]{start, 1});   //시작
            arr.add(new int[]{end, -1});    //끝
        }

        //시작시간 기준으로 정렬
        arr.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else {
                return Integer.compare(a[1], b[1]);
            }
        });

        max_count = 0;
        int count = 0;
        for (int[] value : arr) {
            count+=value[1];    //시작이면 +1, 끝이면 -1
            max_count = Math.max(max_count, count);
        }

        System.out.println(max_count);
    }
}
