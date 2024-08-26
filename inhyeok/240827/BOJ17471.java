package homework;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ17471 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 구역 수
		int n = sc.nextInt();

		// 인구 정보 (1 ~ n번 노드)
		int[] population = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			population[i] = sc.nextInt();
		}

		// n x n 인접 행렬
		boolean[][] adjArray = new boolean[n + 1][n + 1];

		// 인접리스트
		Node[] adjList = new Node[n + 1];

		// 간선 정보 입력받아 저장
		for (int currNode = 1; currNode <= n; currNode++) {
			int adjCount = sc.nextInt();

			for (int j = 0; j < adjCount; j++) {
				int nextNode = sc.nextInt();

				// 인접 행렬 저장
				adjArray[currNode][nextNode] = true;
				adjArray[nextNode][currNode] = true;

				// 인접 리스트 저장
				adjList[currNode] = new Node(nextNode, adjList[currNode]);
//				adjList[nextNode] = new Node(currNode, adjList[nextNode]);
			}
		}

		// 출력해보기
		System.out.println("**** 인접 행렬 출력 ****");
		for (int i = 1; i <= n; i++) {
			System.out.println(Arrays.toString(adjArray[i]));
		}
		
		System.out.println("**** 인접 리스트 출력 ****");
		for (int i = 1; i <= n; i++) {
			System.out.println(adjList[i]);
		}
	}

	static class Node {
		int currNode;
		Node nextNode;

		public Node(int currNode, Node nextNode) {
			super();
			this.currNode = currNode;
			this.nextNode = nextNode;
		}

		@Override
		public String toString() {
			return "Node [currNode=" + currNode + ", next=" + nextNode + "]";
		}
	}

}
