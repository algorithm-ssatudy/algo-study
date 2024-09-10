package bj;

import java.util.Scanner;

public class bj_11403 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j< N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i<N; i++) {	// 하나의 정점을 잡고
			for(int j = 0; j< N; j++) {	//모든 쌍에 대해서
				for(int k = 0; k<N; k++) {
					if(arr[j][i]==1 && arr[i][k] ==1) {	//기준 정점을 지나서 갈 수 있는지
						arr[j][k] = 1;
					}
					
				}
			}
		}
		// 답 프린트
		for(int i = 0; i< N; i++) {
			for(int j = 0; j< N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	
	}

}
