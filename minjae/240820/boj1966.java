import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<tc; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			// 앞에서 빼고 뒤에 추가할 수 있도록 deque 사용
			Deque<Paper> dq = new LinkedList<>();
			
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(j==m) {
					dq.add(new Paper(true, num));
				} else {
					dq.add(new Paper(false, num));
				}	
			}
			
			// deque 순회하며 가장 큰 값인지 확인
			int cnt = 1;
			boolean isBig = true;
			
			while(true) {
				Paper p = dq.pollFirst();
				for(Paper temp : dq) {
					if(temp.pri > p.pri) {
						dq.add(p);
						isBig = false;
						break;
					}
				}
				
				//만약 제일 큰 숫자이고, 몇 번째로 인쇄되었는지 확인하고자 하는 문서라면 출력
				if(isBig) {
					if(p.isDoc) {
						System.out.println(cnt);
						break;
					} else {
						cnt++;
					}
				}
				
				isBig = true;
			}
		}
	}
}

class Paper {
	boolean isDoc;
	int pri;
	
	Paper(boolean doc, int pri) {
		this.isDoc = doc;
		this.pri = pri;
	}
}