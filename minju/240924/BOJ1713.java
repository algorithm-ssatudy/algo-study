import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ1713 {
	static int N;
	static LinkedHashMap<Integer, Integer> map; //순서 유지 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		map = new LinkedHashMap<Integer, Integer>(N); //size 지정 
		
		st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		st =new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(st.nextToken()); //학생 번호 
			if(map.containsKey(num)) {
				//이미 있음 
				map.put(num, map.get(num)+1);
			}
			else {
				if(map.size()==N) {
					// 가장 득표수 적은 key 제거 
					int min=Collections.min(map.values());
					for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
						if(entry.getValue()==min) {
							map.remove(entry.getKey());
							break;
						}
					}
				}
				//새 학생 추가 
				map.put(num, 1);
			}
		}
		//순서대로 출력 
		TreeSet<Integer> set = new TreeSet<>(map.keySet());
		StringBuilder sb =new StringBuilder();
		for(int i:set) {
			sb.append(i+" ");
		}
		System.out.println(sb);
		
	}

}
