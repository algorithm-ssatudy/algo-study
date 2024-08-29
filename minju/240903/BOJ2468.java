import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2468 {

	static int dx[]= {1, 0, -1, 0};
	static int dy[]= {0, 1, 0, -1};
	static int map[][];
	static boolean fill[][], visit[][]; //fill[i][j]가 true면 못감 
	static int N, ans, max, min; //min은 가장 낮은 높이 max는 가장 높은 높이-1 
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x=x; this.y=y;
		}
	}
	static void bfs(int i, int j) {
		
		Queue<Point> q=new ArrayDeque<>();
		q.add(new Point(i, j));
		visit[i][j]=true;
		while(!q.isEmpty()) {
			int x=q.peek().x;
			int y=q.peek().y;
			q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx=x+dx[dir];
				int ny=y+dy[dir];
				if(nx<0||nx>=N||ny<0||ny>=N) continue;
				if(fill[nx][ny] || visit[nx][ny]) continue;
				visit[nx][ny]=true;
				q.add(new Point(nx, ny));
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =  new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N][N];
		fill=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=sc.nextInt();
				min=Math.min(min, map[i][j]);
				max=Math.max(max, map[i][j]);
			}
		}
		max--; 
		
		for(int k=min;k<=max;k++) {
			//k는 min부터 max까지 
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					//높이가 k이하면 침수 fill[i][j]=true
					if(map[i][j]<=k) fill[i][j]=true;
				}
			}
			visit=new boolean[N][N]; //새로 할당 
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visit[i][j] && !fill[i][j]) {
						bfs(i, j);
						cnt++; //안전 영역 갯수 (bfs수행 횟수) 
					}
				}
			}
			ans=Math.max(ans, cnt);
		}
		System.out.println(ans);
	}

}
