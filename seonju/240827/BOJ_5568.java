import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//BOJ_5568 카드 놓기
public class BOJ_5568 {
    static int N;   // 카드에 적힌 숫자
    static int K;   // 선택
    static int[] arr;
    static Set<String> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        numbers = new HashSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        perm(0, new boolean[N], new StringBuilder());
        System.out.println(numbers.size());
    }

    public static void perm(int cnt, boolean[] isSelected, StringBuilder sb) {
        if (cnt == K) {
            numbers.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue; // 이미 선택된 카드

            isSelected[i] = true;
            sb.append(arr[i]);

            perm(cnt + 1, isSelected, sb);

            sb.setLength(sb.length() - Integer.toString(arr[i]).length());  //마지막에 추가된 숫자 제거
            isSelected[i] = false;
        }
    }
}
