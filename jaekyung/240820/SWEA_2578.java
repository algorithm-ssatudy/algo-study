

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_2578 {
    static final int N = 5;
    static int bingo = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        Map<Integer, int[]> map = new HashMap<>(); // 해당하는 숫자의 행과 열 저장
        bingo = 0;
        int[] row = new int[N]; // 행의 bingo 수 저장
        int[] col = new int[N]; // 열의 bingo 수 저장
        int right = 0; // 오른쪽 대각선 bingo 수 저장
        int left = 0; // 왼쪽 대각선 bingo 수 저장
        for(int i = 0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<N ; j++){
                int num = Integer.parseInt(st.nextToken());
                map.put(num, new int[]{i, j});
            }
        }
        int answer = 0;
        boolean stop = false;
        for(int i = 0 ; i<N ; i++){ // while문으로 푸는 게 더 나을듯
            if(stop) break;
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<N ; j++){
                answer++;
                int num = Integer.parseInt(st.nextToken());
                int[] position = map.get(num); // 숫자에 해당하는 행과 열 가져오기
                int x = position[0];
                int y = position[1];
                //해당하는 곳에 빙고 체크 -> 5개 체크되었다면 bingo 수 증가 !
                if(++row[x]>=5) bingo++;
                if(++col[y]>=5) bingo++;
                if(x==y){
                    if(++left>=5) bingo++;
                }
                if(x+y==4) {
                    if(++right>=5) bingo++;
                }
                if(bingo>=3){ // bingo가 3이상이라면 for문 멈추기
                    stop = true;
                    System.out.println(answer);
                    break;
                }
            }
        }
    }
}