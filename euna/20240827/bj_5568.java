package bj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj_5568 {
	static int n, k;
	static int[] v;
	static String[] arr;
	static List<String> result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		arr = new String[n];		//카드 숫자 배열 
		v = new int[n];	//방문체크배열 
		for(int i = 0; i<n;i++) {
			arr[i] = sc.next();
		}
		
		
		result = new ArrayList<>();
		dfs(0, "");
//		for(int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i));
//		}
		
		System.out.println(result.size());
		
	}
	//순열 
	static void dfs(int idx,String str) {
		// TODO Auto-generated method stub
		if(idx==k) {
			if(!result.contains(str)) {
				result.add(str);
			}
			return;
		}
		
		for(int i=0; i< n; i++) {
			if(v[i]==1)continue;
			v[i] = 1;
			dfs(idx+1,str + arr[i]);
			v[i] = 0;
			
		}
	}

}
