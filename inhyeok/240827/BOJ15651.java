package codingTest;

import java.util.Scanner;

public class BOJ15651 {
    static int N, M;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        makePermutation(0, new StringBuilder());

        // 결과를 한 번에 출력
        System.out.print(result);
    }

    public static void makePermutation(int count, StringBuilder permutation) {
        if (count == M) {
            result.append(permutation).append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            int length = permutation.length();  // 현재 길이를 기억해둔다
            permutation.append(i).append(" ");  // 숫자 추가
            makePermutation(count + 1, permutation);
            permutation.setLength(length);  // 원래 길이로 되돌린다 (추가한 숫자 제거)
        }
    }
}
