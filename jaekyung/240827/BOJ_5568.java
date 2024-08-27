import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static boolean[] visited ;
    static int n, k ;
    static String arr[] ;
    static Set<String>  set ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        visited = new boolean[n];
        set = new HashSet<>(); // 중복 없는 수를 만들기 위한 hashset
        for(int i = 0 ; i<n ;i++){

            arr[i] = br.readLine();
        }
        findNumber(0, "");
        System.out.println(set.size());
    }
    public static void findNumber(int depth, String num ){
        if(depth==k){ // k만큼 선택했으면
            set.add(num);
            return ;
        }
        for(int i = 0 ; i<n ;i++){
            if(visited[i]) continue;// 방문 체크
            visited[i] = true;
            findNumber(depth+1, num+arr[i]); // 반복 !
            visited[i] = false;
        }
    }
}
