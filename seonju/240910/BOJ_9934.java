import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ_9934 완전 이진 트리
public class BOJ_9934 {
    static ArrayList<Integer>[] list;
    static int[] arr;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        int size = (int) (Math.pow(2, K) - 1); // 크기
        arr = new int[size];
        list = new ArrayList[size];
        // 초기화
        for (int i = 0; i < size; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0, size, 0);
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                System.out.print(list[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void find(int start, int end, int depth) {
        if (K == depth)
            return; // 모두 확인

        int mid = (start + end) / 2;

        list[depth].add(arr[mid]);

        // 왼쪽
        find(start, mid - 1, depth + 1);

        // 오른쪽
        find(mid + 1, end, depth + 1);
    }
}
