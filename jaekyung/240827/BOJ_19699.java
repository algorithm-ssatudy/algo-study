import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n, m ;
    static int arr[] ;
    static Set<Integer> set;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<n ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0,0,0);
        if(set.isEmpty()) System.out.println(-1);
        else {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            for(int a : list){
                System.out.print(a+" ");

            }
            System.out.println();
        }


    }

    public static boolean isPrime(int num){
        if(num < 2) return false;
        int sqrt = (int)Math.sqrt(num);  // 제곱근을 미리 계산해둠
        for(int i = 2; i <= sqrt; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void dfs(int num, int sum, int idx){
        if(num==m) {
            if(isPrime(sum)) {
                set.add(sum);
            }
            return;
        }
        if(idx==n) return;
        dfs(num+1, sum+arr[idx], idx+1);
        dfs(num, sum, idx+1);
    }
}
