


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1966 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for(int t = 0 ; t<testCase ; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Deque<int[]> deque = new ArrayDeque<>(); // 양 옆으로 넣고 뺄 수 있는 deque 활용
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i<n ; i++){
                int impo = Integer.parseInt(st.nextToken());
                deque.addLast(new int[]{impo, i}); // 중요도, index
            }
            int cnt = 0;
            while(!deque.isEmpty()){
                boolean pass = true; // 현재 문서 인쇄하는 지 체크
                int[] document = deque.pollFirst() ; // 가장 첫 번째꺼 가져오기
                for(int[] next: deque){ // 다음 문서 중 중요도가 높은 것이 있는지 체크
                    if(document[0]<next[0]){
                        pass = false;
                        deque.addLast(document); // 그런 경우 마지막에 넣어주기
                        break;
                    }
                }
                if(pass) cnt++; // 인쇄된 문서들 count
                if(document[1]==m && pass) break; // 찾던 인덱스 이면서, 가장 중요도가 높은 경우
            }
            System.out.println(cnt);
        }

    }
}