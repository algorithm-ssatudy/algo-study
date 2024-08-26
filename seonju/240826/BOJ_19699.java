import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//BOJ_19699 소-난다!
public class BOJ_19699 {
    static int N, M;    //소들의 수 N, 선별할 소의 수 M
    static int[] weight;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weight = new int[N];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0, 0);
        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            //오름차순
            list.sort(Comparator.naturalOrder());
            for (int val : list) {
                System.out.print(val + " ");
            }
        }
    }

    public static void comb(int index, int count, int sum) {
        if (count == M && !list.contains(sum)) {   //M마리 선택
            if (isPrime(sum)) {
                list.add(sum);
            }
            return;
        }

        if (index == N) {   //다 확인했으면 리턴
            return;
        }

        comb(index + 1, count + 1, sum + weight[index]);
        comb(index + 1, count, sum);
    }

    // Prime number checker
    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
//        if (num <= 1) {
//            return false;
//        }
//        if (num == 2 || num == 3) {
//            return true;
//        }
//        if (num % 2 == 0) {
//            return false;
//        }
//        for (int i = 3; i * i <= num; i += 2) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
