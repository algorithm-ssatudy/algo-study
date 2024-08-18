import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//BOJ_1966 프린터 큐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    //테스트케이스
        for (int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());   //문서 개수
            int M = Integer.parseInt(st.nextToken());   //몇번째
            LinkedList<int[]> queue = new LinkedList<>();    //위치, 중요도 저장
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) { //위치, 중요도 저장
                queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int order = 0;
            while (!queue.isEmpty()) {
                boolean is_max = true; //우선순위 가장 크다고 가정
                int[] current = queue.poll();   //현재 상태
                for (int i = 0; i < queue.size(); i++) {
                    if (current[1] < queue.get(i)[1]) {  //우선순위 작으면 뒤로 이동
                        queue.offer(current);   //뒤에 붙여넣기
                        for (int j = 0; j < i; j++) {   //i번째를 가장 앞으로 이동
                            queue.offer(queue.poll());  //뒤에 붙여넣기
                        }
                        is_max = false;
                        break;  //다음단계 진행
                    }
                }
                if (!is_max) continue;
                order++;
                if (current[0] == M) break;  //원하는 위치면 break
            }
            System.out.println(order);
        }
    }
}