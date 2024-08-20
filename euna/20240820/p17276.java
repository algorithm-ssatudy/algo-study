package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17276 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
//		int T = 1;
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int deg = Integer.parseInt(st.nextToken());
			
			int [][] arr = new int[n][n];	//배열을 담을 arr 
			
			
			for(int i=0; i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int cnt = Math.abs(deg/45);
			
			for(int c = 0; c< cnt;c++) {
				if(deg==0) {
					break;
				}
				
				else if(deg >0) {
					//1->2
					int[] temp1 = new int[n];
					for(int i=0; i<n;i++) {
						temp1[i] = arr[i][(n-1)/2];		//2
						arr[i][(n-1)/2] = arr[i][i];
					}
					//2->3
					int[] temp2 = new int[n];
					for(int i=0; i<n;i++) {
						temp2[i] = arr[i][n-1-i];		//3
						arr[i][n-1-i] = temp1[i];
					}
					//3->4
					temp1 = new int[n];
					for(int i=0; i<n;i++) {
						temp1[i] = arr[(n-1)/2][n-1-i];		//4
						arr[(n-1)/2][n-1-i] = temp2[i];
					}
					//4->1
					
					for(int i=0; i<n;i++) {
						arr[i][i] = temp1[n-1-i];
					}
					
					
				}
				
				else {
					//4->3
					int[] temp1 = new int[n];
					for(int i=0; i<n;i++) {
						temp1[i] = arr[i][n-1-i];		//3
						arr[i][n-1-i] = arr[(n-1)/2][n-1-i];
					}
					//3->2
					int[] temp2 = new int[n];
					for(int i=0; i<n;i++) {
						temp2[i] = arr[i][(n-1)/2];		//2
						arr[i][(n-1)/2] = temp1[i];
					}
					//2->1
					temp1 = new int[n];
					for(int i=0; i<n;i++) {
						temp1[i] = arr[i][i];		//1
						arr[i][i] = temp2[i];
					}
					//1->4
					
					for(int i=0; i<n;i++) {
						arr[(n-1)/2][n-1-i] = temp1[n-1-i];
					}
				}
				
				
			}//for끝
			
		for(int i = 0; i < n; i++) {
			for(int j =0; j<n;j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		
		
			
			
			
		}
		
		System.out.println(sb);
	}

}
