import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BOJ19699 {
	
	
	//몸무게의 합 소수
	//조합
	static boolean check[]; //idx번째 소가 선택되었는지
	static int arr[];
	static int n, m;
	static boolean p[]=new boolean[9001];
	static Set<Integer> set = new TreeSet<>(); //오름차순 중복 제거
	static void dfs(int depth, int sum, int idx){
		if(depth==m) {
			if(p[sum]) {
				//소수면 
				set.add(sum);
			}
			return;
		}
		for(int i=idx;i<n;i++) {
			if(!check[i]) {
				check[i]=true;
				dfs(depth+1 ,sum+arr[i], idx+1);
				check[i]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		check=new boolean[n];
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.fill(p, true);
		p[0]=false;
		p[1]=false;
		for(int i=2;i*i<=9000;i++) {
			if(p[i]) {
				for(int j=i*2;j<=9000;j+=i) {
					p[j]=false;
				}
			}
		}
		//소수 판별 -> 소수면 true
		//최대 1000, 9개 가능하므로 9000까지 소수 구함
		
		dfs(0, 0, 0);
		if(set.size()==0) System.out.println(-1);
		else {
			for(int i:set) {
				System.out.print(i+" ");
			}
		}
	}
}
