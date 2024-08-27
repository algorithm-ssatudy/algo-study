import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1941 {

	// 0 1 2 3 4 
	// 5 6 7 8 9
	// 10 11 12 13 14
	// 15 16 17 18 19
	// 20 21 22 23 24
	static char map[][]=new char[5][5];
	static boolean select[]=new boolean[25];
	static int ans=0;
	static int dx[]= {1, 0, -1, 0};
	static int dy[]= {0, 1, 0, -1};
	static int num[][]=new int[5][5]; //25���� �� 7���� ���� ��ǥ�� ��ȯ
	static class point {
		int x, y;
		public point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static boolean adj() {
		//check�� true�� �͵��� ���� �������ִ���
		for(int i=0;i<5;i++) {
			Arrays.fill(num[i], 0);
		}
		boolean check[][]=new boolean[5][5];
		boolean flag = false;
		Queue<point> q = new ArrayDeque<>();
		for(int i=0;i<25;i++) {
			if(select[i]) {
				int x = i/5;
				int y = i%5;
				if(!flag) {
					//���� ó�� ����
					check[x][y]=true;
					q.add(new point(x, y));
					flag=true;
				}
				num[x][y]=1;
			}
		}
		
		int cnt = 1; //cnt�� 7�� �Ǹ� ��� ����, true ��ȯ
		while(!q.isEmpty()) {
			int x=q.peek().x;
			int y=q.peek().y;
			q.poll();
			if(cnt==7) return true;
			for(int i=0;i<4;i++) {
				int nx =dx[i]+x;
				int ny =dy[i]+y;
				if(nx<0 || nx>=5 || ny<0 || ny>=5) continue;
				if(!check[nx][ny] && num[nx][ny]==1) {
					q.add(new point(nx, ny));
					check[nx][ny]=true;
					cnt++;
				}
			}
		}
		return false;
	}
	static boolean four() {
		//�̴ټ��İ� 4�� �̻�����
		int f =0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(num[i][j]==1 && map[i][j]=='S') f++;
			}
		}
		return f>=4?true:false;
	}
	static void dfs(int depth, int idx) {
		//25�� �� 7���� ����, ����
		if(depth==7) {
			//�������� Ȯ��
			//s�� 4�� �̻����� Ȯ��
			if(adj() && four()) ans++;
			return;
		}
		for(int i=idx;i<25;i++) {
			if(!select[i]) {
				select[i]=true;
				dfs(depth+1, i+1);
				select[i]=false;
			}
		}
	
	}
	public static void main(String[] args) throws IOException {
		//5*5�� ��ġ
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			String s = sc.next();
			for(int j=0;j<5;j++) {
				map[i][j]=s.charAt(j);
			}
		}
		dfs(0, 0);
		System.out.println(ans);
		
	}

}
