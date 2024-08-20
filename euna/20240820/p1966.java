package bj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		
		for(int t = 0; t < T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			Queue<Integer> queue = new ArrayDeque<Integer>();		//중요도를 넣을 큐 
			Queue<Integer> queue2 = new ArrayDeque<>();				//문서의 인덱스를 넣을 큐 
			List<Integer> arr = new ArrayList<Integer>();			//문서의 중요도를 내림차순으로 저장할 arr 
		
			//input 넣
			for(int i = 0; i<N;i++) {
				int input = sc.nextInt();		//중요도 
				
				queue.offer(input);
				queue2.offer(i);
				arr.add(input);
				
			}
			
			arr.sort(Comparator.reverseOrder());		//중요도 내림차순으로 정렬 
			
			int idx = 0;	//최대 중요도의 인덱스 
			int cnt = 0;	//출력횟수
			
			while(!queue.isEmpty()) {
				int num = queue.peek();		//문서의 중요도 
				int num_idx = queue2.peek();	//문서의 인덱스 
				
				if(num != arr.get(idx)) {	//현재 문서의 중요도가 최대가 아니라면 
					//빼서 맨 뒤로 넣기 
					queue.offer(num);//뒤에 넣기 
					queue.poll();	//큐에서 빼
					
					queue2.offer(num_idx);//뒤에 넣기 
					queue2.poll();	//큐에서 빼
					
					continue;
				}
				else if(num ==arr.get(idx)) {	//현재 문서의 중요도가 최대라면 
					idx++;	//다음 최대값 
					
					queue.poll();	//문서빼
					queue2.poll();
					cnt++;	//출력 횟수 증가 
					if(num_idx==M) break;	//현재 문서의 인덱스가 내가 궁금한 문서의 인덱스라면 답 출
					continue;
				}
				
				
			}
			
			sb.append(cnt).append("\n");
			
		}
		
		System.out.println(sb);
		
		
		
	}

}
