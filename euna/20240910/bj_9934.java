package bj;


import java.util.ArrayList;
import java.util.Scanner;

public class bj_9934 {
	static int K, num;
	static int[] arr;
	static ArrayList<Integer>[] tree;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		
		
		num = (int) (Math.pow(2, K) -1);		//노드 수
		arr = new int[num];		//입력 배열
		
		//입력 받기
		for(int i =0; i< num; i++) {
			arr[i] = sc.nextInt();
		}
		
		//depth별로 노드 저장 하기 위한  arraylist 배열
		//depth가 1부터라고 해서 K+1!!
		tree = new ArrayList[K+1];
		for(int i = 1; i<K+1;i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		//재귀
		dfs(0, num-1, 1);
		
		//출력
		for(int i = 1; i< K+1; i++) {
			for(int j = 0; j < tree[i].size(); j++) {
				System.out.print(tree[i].get(j) + " ");
			}
			System.out.println();
		}
		

		
	}
	
	static void dfs(int s, int e, int depth) {
		if(depth==K+1) {
			return;
		}
		
		int mid = (e+s)/2;
		tree[depth].add(arr[mid]);	//현재 트리의 루트노드 저장
		
		dfs(s, mid-1, depth+1);	//왼쪽 서브트리
		dfs(mid+1, e, depth+1);	//오른쪽 서브트리
		
		
	}
	

}
