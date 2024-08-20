import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17276 {
	
	static int T;
	static int board[][];
	static int temp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T=Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=T;tc++) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			board=new int[n][n];
			temp=new int[n][n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					board[i][j]=Integer.parseInt(st.nextToken());
					temp[i][j]=board[i][j];
				}
			}
			d/=45;
			if(d>0) {
				//오른쪽으로 회전
				while(d>0) {
					for(int i=0;i<n;i++) {
						board[i][n/2]=temp[i][i];
					}
					for(int i=0;i<n;i++) {
						board[i][n-1-i]=temp[i][n/2];
					}
					for(int i=n-1;i>=0;i--) {
						board[n/2][i]=temp[n-i-1][i];
					}
					for(int i=n-1;i>=0;i--) {
						board[i][i]=temp[n/2][i];
					}
					//원래대로 돌려줌
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							temp[i][j]=board[i][j];
						}
					}
					d--;
				}
			}
			else {
				d=Math.abs(d);
				while(d>0) {
					for(int i=0;i<n;i++) {
						board[n/2][i]=temp[i][i];
					}
					for(int i=0;i<n;i++) {
						board[n-1-i][i]=temp[n/2][i];
					}
					for(int i=n-1;i>=0;i--) {
						board[i][n/2]=temp[i][n-i-1];
					}
					for(int i=n-1;i>=0;i--) {
						board[i][i]=temp[i][n/2];
					}
					
					//원래대로 돌려줌
					for(int i=0;i<n;i++) {
						for(int j=0;j<n;j++) {
							temp[i][j]=board[i][j];
						}
					}
					d--;
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}

}
