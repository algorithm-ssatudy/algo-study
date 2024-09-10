package bj;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class bj_2468 {
	static int N, rain, cnt, num;
	static int[] dr = {-1, 1 ,0, 0}, dc = {0, 0, -1, 1};
	static int[][] arr, v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N][N];
		
		int max = 0;	// 빗물높이의 최소 
		int min = 101;	// 빗물 높이의 최대 
		//입력 받으면서 최소, 최대값도 같이 구하기 
		for(int i = 0; i <N; i++) {
			for(int j = 0; j<N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]> max) max = arr[i][j];
				if(arr[i][j] < min) min = arr[i][j];
				
			}
		}
		
		cnt = 1; // 답, 아무 지역도 물에 잠기지 않은 경우 최대 구역수는 1이라서 
		// 빗물을 증가시키면서 
		for(rain = min; rain <max; rain++) {
			v = new int[N][N];	// 빗물높이가 달라질때마다 방문 배열 초기화 
			num=0;	//해당 빗물높이 마다의 안전 구역의 개수 
			for(int i = 0; i< N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] - rain>0 && v[i][j] ==0) {
						num++;	//새로운 안전구역일때 마다 값 +1
						bfs(i,j);
						
					}
				}
			}
			cnt = Math.max(cnt, num);	//최대 안전구역 개수 
		}
		
		System.out.println(cnt);
		
		
		
		
		
	}
	static void bfs(int sr, int sc) {
		// TODO Auto-generated method stub
		Queue<Node> q = new ArrayDeque<>();
		
		Node start = new Node(sr, sc, arr[sr][sc] - rain);
		
		q.offer(start);
		v[sr][sc] = num;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			//상하좌우 
			for(int i = 0; i< 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr <0 || nc<0 || nr>=N || nc >=N || (arr[nr][nc]-rain <=0) || v[nr][nc] !=0) {
					continue;
				}
				
				else {
					Node next = new Node(nr, nc, arr[nr][nc] - rain);
					q.offer(next);
					v[nr][nc] = num;
					
				}
				
				
			}
			
		}

		
	}
	static class Node{
		int r;
		int c;
		int val;
		
		public Node(int r, int c, int val) {
			super();
			this.r = r;
			this.c = c;
			this.val = val;
		}
		
		
	}

}
