package bj;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class bj_19699 {
	static int N, M;
	static int[] arr;
	static Set<Integer> result;
	
	static StringBuilder sb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		result = new HashSet<>();
		sb = new StringBuilder();
		dfs(0, 0, 0);
		
		List<Integer> tempList = new ArrayList<>(result);
		if(result.isEmpty()) {
			sb.append(-1);
		}
		else {
			//정렬 
			Collections.sort(tempList);
			for(int sum: tempList) {
				sb.append(sum).append(" ");
			}
		}
		System.out.println(sb);
		
		
	}
	static void dfs(int idx, int start, int sum) {
		// TODO Auto-generated method stub
		if(idx==M) {
			//소수이면서 중복이 아니면 출
			if(isPrime(sum)) {

				result.add(sum);
			}
			return;
		}
		
		for(int i=start; i<N;i++) {
			dfs(idx+1, i+1, sum+ arr[i]);
		}
	}
	static boolean isPrime(int sum) {
		// TODO Auto-generated method stub
		if(sum <=1) return false;
		for(int i = 2; i<= Math.sqrt(sum); i++) {	//1보다 크고 sum의 제곱근 보다 작은 수들로 안 나눠지면 소수 
			if(sum%i==0) return false;
		}
		return true;
	}

}
