import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//BOJ_2468 안전 영역
public class BOJ_2468 {
    static int N;
    static int[][] map;
    static Set<Integer> rain = new HashSet<>(); //비의 양 -> 중복 없애기 위해 hashSet 사용
    static int max; //안전 영역
    static boolean[][] visited;

    //4방향 탐색
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];    //방문 배열 초기화

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                rain.add(map[i][j]);    //비의 양 저장
            }
        }

        for (int r : rain) {    //비의 양만큼 반복
            int count = 0;
            visited = new boolean[N][N];    //방문 배열 초기화

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] >= r && !visited[i][j]) {  //잠기지 않고 방문하지 않았을 때
                        count++;
                        bfs(i, j, r);
                    }
                }
            }
            max = Math.max(max, count); //안전영역 업데이트
        }
        System.out.println(max);
    }

    static void bfs(int x, int y, int rain) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;   //방문 처리

        while (!queue.isEmpty()) {
            int cur[] = queue.poll();

            //4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || visited[nx][ny]) continue;
                if (map[nx][ny] < rain) continue; //잠기는 영역일 때

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}
