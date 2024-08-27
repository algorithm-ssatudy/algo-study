import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//BOJ_1941 소문난 칠공주
public class BOJ_1941 {
    static char[][] map = new char[5][5];
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        List<int[]> positions = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            positions.add(new int[]{i / 5, i % 5});
        }

        position(positions, new boolean[25], 0, 0);

        System.out.println(result);
    }

    private static void position(List<int[]> positions, boolean[] visited, int index, int depth) {
        if (depth == 7) {   //7자리 선택했을 때
            char[][] selected = new char[5][5];
            int countS = 0;
            int startX = -1, startY = -1;

            // 7개 위치 찾기
            for (int i = 0; i < 25; i++) {
                if (visited[i]) {
                    int x = positions.get(i)[0];
                    int y = positions.get(i)[1];
                    selected[x][y] = map[x][y];
                    if (map[x][y] == 'S') countS++;
                    if (startX == -1) { //선택 안된 상태일 때
                        startX = x;
                        startY = y;
                    }
                }
            }

            if (countS >= 4 && bfs(selected, startX, startY)) { //S의 수가 4이상이고 연결되어 있을 때
                result++;
            }
            return;
        }

        if (index >= 25) return;

        visited[index] = true;
        position(positions, visited, index + 1, depth + 1);
        visited[index] = false;
        position(positions, visited, index + 1, depth);
    }

    private static boolean bfs(char[][] selected, int startX, int startY) { //bfs 실행
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny] || selected[nx][ny] == 0) continue;
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                count++;
            }
        }

        return count == 7;
    }
}
