package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2578 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][] arr = new int[25][2];	//좌표를 넣을 배열 
		int [][] v = new int[25][25];
		
		//숫자의 좌표를 저장 
		for(int i = 0; i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j < 5;j++) {
				int num = Integer.parseInt(st.nextToken())-1;
				arr[num] = new int[]{i, j};
			}
			
		}
		
		int sol = 0;
		int line_num = 0;
		
		outer:		//brea문을 한 번에 벗어나기 위한 라
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5;j++) {
				int num = Integer.parseInt(st.nextToken())-1;
				int x = arr[num][0];
				int y = arr[num][1];
				
				v[x][y] = 1;
				sol++;
				
				int cnt = 0;
				
		
				//왼쪽 대각선 
				if(x==y) {
					for(int k = 0; k<5;k++) {
						if(v[k][k]==1) cnt++;
					}
					if(cnt==5) line_num++;
				}
				
				cnt = 0;
				//오른쪽 대각선 
				if(x+y ==4) {
					
					for(int k = 0; k<5;k++) {
						if(v[k][4-k]==1) cnt++;
					}
					if(cnt==5) line_num++;
				}
				
				
				
				cnt = 0;	
				//가로 
				for(int k = 0; k<5;k++) {
					if(v[x][k]==1) cnt++;
				}
				if(cnt==5) line_num++;
				
				cnt=0;
				//세로 
				for(int k = 0; k<5;k++) {
					if(v[k][y]==1) cnt++;
				}
				if(cnt==5) line_num++;
				
				if(line_num>=3) {
					break outer;
				}
			}
			
			
		}
		System.out.println(sol);
		
		
		
		
	}

}
