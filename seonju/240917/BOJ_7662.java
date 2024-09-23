import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_7662 {
    static PriorityQueue<Integer> minQueue;
    static PriorityQueue<Integer> maxQueue;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            minQueue = new PriorityQueue<>();
            maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (command) {
                    case "I":
                        minQueue.add(num);
                        maxQueue.add(num);
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    case "D":
                        if (num == 1) { // 최대값 삭제
                            delete(maxQueue);
                        } else { // 최소값 삭제
                            delete(minQueue);
                        }
                        break;
                }
            }

            while (!maxQueue.isEmpty() && map.getOrDefault(maxQueue.peek(), 0) == 0) {
                maxQueue.poll();
            }
            while (!minQueue.isEmpty() && map.getOrDefault(minQueue.peek(), 0) == 0) {
                minQueue.poll();
            }

            if (maxQueue.isEmpty() || minQueue.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                int max = maxQueue.poll();
                int min = minQueue.poll();
                System.out.println(max + " " + min);
            }
        }
    }

    public static void delete(PriorityQueue<Integer> queue) {
        while (!queue.isEmpty()) {
            int val = queue.poll();
            int count = map.getOrDefault(val, 0);
            if (count > 0) {
                map.put(val, count - 1);
                return;
            }
        }
    }
}
