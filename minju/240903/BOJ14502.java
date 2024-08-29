import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14502 {

	static int N, M, ans;
	static int map[][]; //1은 벽, 2는 바이러스 
	static int tmp[][];
	static int dx[]= {1, 0, -1, 0};
	static int dy[]= {0, 1, 0, -1};
	static class Point{
		int x, y;
		 public Point(int x, int y) {
			this.x=x; this.y=y;
		}
	}
	static int bfs() {
		//안전 영역의 갯수 구하기 위해서 2가 있는 곳 시작점으로 bfs
		Queue<Point> q= new ArrayDeque<>();
		boolean visit [][]=new boolean[N][M];
		tmp=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmp[i][j]=map[i][j];
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==2){
					visit[i][j]=true;
					q.add(new Point(i,j)); //2가 있는 곳 추가  
				}
			}
		}
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			for(int i=0;i<4;i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(!visit[nx][ny] && map[nx][ny]==0) {
					visit[nx][ny]=true;
					map[nx][ny]=2;
					q.add(new Point(nx, ny));
				}
			}
		}
		//바이러스(2)를 기준으로 bfs
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) cnt++;
				map[i][j]=tmp[i][j]; //원상복
			}
		}
		
		return cnt;
	}
	static void dfs(int depth) {
		if(depth==3) {
			//현재 map가지고 bfs
			int cnt=bfs();
			ans=Math.max(ans, cnt);
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(depth+1);
					map[i][j]=0;
				}
			}
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j]=sc.nextInt();
			}
		}
		//좌표 3개 고름
		dfs(0);
		System.out.println(ans);
	}

}
