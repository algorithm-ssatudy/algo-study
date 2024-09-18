package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ7662_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int round = 1; round <= T; round++) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();			
			
			int opCnt = Integer.parseInt(br.readLine());
			for (int i = 0; i < opCnt; i++) {						
				st = new StringTokenizer(br.readLine());
				
				String op = st.nextToken();
				
				// 입력 연산 
				if (op.equals("I")) {
					int num = Integer.parseInt(st.nextToken());
					
					int count = treeMap.getOrDefault(num, 0);
					
					// 새로운 숫자면 0 + 1 = 1이 들어감, 기존에 있는 숫자면 count + 1이 들어감 
					treeMap.put(num, ++count);					
				} 
				// 삭제 연산 
				else {
					// 비어있으면 무시 
					if (treeMap.isEmpty()) {
						continue;
					} else {
						int op2 = Integer.parseInt(st.nextToken());
						int count = 0;
						
						switch(op2) {						
						// 최소값 삭제 
						case -1 :
							int minValue = treeMap.firstKey();
							count = treeMap.getOrDefault(minValue, 0);
							
							treeMap.put(minValue, --count);
							
							// 그 숫자의 갯수가 0이되면 없는 숫자이므로 treeMap에서 방출 
							if (count == 0) {
								treeMap.remove(minValue);
							}
							
							break;
						// 최대값 삭제 
						case 1 :
							int maxValue = treeMap.lastKey();
							count = treeMap.getOrDefault(maxValue, 0);
							
							treeMap.put(maxValue, --count);
							// 그 숫자의 갯수가 0이되면 없는 숫자이므로 treeMap에서 방출 
							if (count == 0) {
								treeMap.remove(maxValue);
							}
							
							break;
						}
					}
				}
			}
			
			// 연산 종료 후 
			if (treeMap.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(treeMap.lastKey()+" "+treeMap.firstKey());
			}
		}
	}

}
