import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n, m ;
    static int arr[] ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        findNumber(0);
        System.out.print(sb); // 모든 출력 한꺼번에
    }
    public static void findNumber(int depth){
        if(depth==m){
            for(int i = 0 ; i<m ; i++){
                sb.append(arr[i]).append(" "); // 결과를 StringBuilder에 추가
            }
            sb.append("\n");
            return;
        }
        for(int i = 1 ; i<n+1 ;i++){
            arr[depth] = i;
            findNumber(depth+1);
        }
    }
}
