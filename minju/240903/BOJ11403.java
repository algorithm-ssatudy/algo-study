import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11403 {
	//경로찾기  
	static int arr[][];
	static boolean visit[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N+1][N+1];
		visit=new boolean[N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j]=sc.nextInt();
			
			}
		}
		
		//플로이드 워셜 
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(arr[i][k]==1 && arr[k][j]==1) arr[i][j]=1;
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
