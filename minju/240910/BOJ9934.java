import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9934 {

	static int K, arr[];
	static ArrayList<Integer> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken());
		arr=new int[(int) (Math.pow(2, K)-1)]; //완전 이진 트리 
		st=new StringTokenizer(br.readLine());
		list=new ArrayList[K]; //depth만큼 넣음 
		for(int i=0;i<K;i++) {
			list[i]=new ArrayList<>();
		}
		for(int i=0;i<(int) (Math.pow(2, K)-1);i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		preorder(0, arr.length-1, 0);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<K;i++) {
			for(int j=0;j<list[i].size();j++) {
				sb.append(list[i].get(j)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void preorder(int st, int en, int depth) {
		if(depth==K) {
			return;
		}
		int mid=(st+en)/2;
		list[depth].add(arr[mid]);
		preorder(st, mid-1, depth+1);
		preorder(mid+1, en, depth+1);
		
	}
}
