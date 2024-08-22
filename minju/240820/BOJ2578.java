import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ2578 {
	


	static boolean board[][]=new boolean[5][5];
	static Map<Integer, Point> m = new HashMap<>(); //m[num]={x, y}
	static boolean isR[]= new boolean[5]; //n번째 행이 빙고인지
	static boolean isC[]= new boolean[5]; //n번째 열이 빙고인지
	static boolean isB[]=new boolean[2]; //0은 /1 1은 \
	static int bingo=0; //빙고 개
	public static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x=x; this.y=y;
		}
	}
	static void row(int r) {
		//r번째 행이 빙고인지
		for(int i=0;i<5;i++) {
			if(board[r][i]) {
				return;
			}
		}
		//r번째가 빙고라면 
		bingo++;
		isR[r]=true;
	}
	static void col(int c) {
		//c번째 행이 빙고인지 
		for(int i=0;i<5;i++) {
			if(board[i][c]) {
				return;
			}
		}
		bingo++;
		isC[c]=true;
	}
	static void a() {
		for(int i=0;i<5;i++) {
			if(board[4-i][i]) return;
		}
		bingo++;
		isB[0]=true;
	}
	static void b() {
		for(int i=0;i<5;i++) {
			if(board[i][i]) return;
		}
		bingo++;
		isB[1]=true;
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				int n=Integer.parseInt(st.nextToken());
				m.put(n, new Point(i, j));
				board[i][j]=true;
			}
		}
		for(int i=1;i<=5;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=5;j++) {
				int n=Integer.parseInt(st.nextToken()); //사회자가 부르는 숫자
				int x=m.get(n).x;
				int y=m.get(n).y;
				//위치 알아냄 
				board[x][y]=false;
				//이미 빙고인 행이나 열은 뛰어넘음
				//x행 검사
				if(!isR[x]) row(x);
				//y열
				if(!isC[y]) col(y);
				//x==y라면 대각선
				if(!isB[0]) a();
				if(!isB[1]) b();
				if(bingo>=3) {
					//빙고 3이상
					System.out.println((i-1)*5+j);
					return;
				}
				
			}
		}

	}

}
