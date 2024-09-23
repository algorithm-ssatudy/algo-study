import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ7662 {

	static int T, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		T=Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			K=Integer.parseInt(st.nextToken());
			//TreeSet <Integer> s= new TreeSet<Integer>();
			
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			// 숫자와 그 숫자가 맵에 몇개 있는지 저장 -> getOrDefault(num, 0) + 1
			
			while(K-->0) {
				st=new StringTokenizer(br.readLine());
				char ch=st.nextToken().charAt(0);
				int num=Integer.parseInt(st.nextToken());
				if(ch=='D') {
					if(map.size()==0) continue;
					//1이면 최대값 제거 -1이면 최소값 제거 
					int key=num==1?map.lastKey():map.firstKey();
					int cnt=map.get(key);
					if(cnt==1) map.remove(key);
					else map.put(key, cnt-1); //갯수가 1이 아니면 갯수 감소해서 집어넣음, key는 중복될 수 x
					
				}
				else {
					map.put(num, map.getOrDefault(num, 0)+1);
				}
			}
			if(map.isEmpty()) sb.append("EMPTY");
			else sb.append(map.lastKey()+" "+map.firstKey());
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
