import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BOJ5568 {

	static int n, k;
	static int arr[];
	static boolean check[];
	static Set<Integer> s =new TreeSet<>();
	static void dfs(int depth, String str) {
		//순열
		if(depth==k) {
			s.add(Integer.parseInt(str));
			return;
			
		}
		for(int i=0;i<n;i++) {
			if(!check[i]) {
				//i번째 숫자를 사용하지 않음
				check[i]=true;
				dfs(depth+1, str+ Integer.toString(arr[i]));
				check[i]=false;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		//n개 중 k개 뽑아서 만들 수 있는 수 
		arr=new int[n];
		check=new boolean[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		dfs(0, "");
		System.out.println(s.size());
	}

}
