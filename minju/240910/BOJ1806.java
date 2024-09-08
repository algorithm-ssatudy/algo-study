import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
	
	static int N, S, len, ans;
	static int arr[];
	static long sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		arr=new int[N+1]; //조건을 s<=e로 줘서 배열 크기를 N으로 두면 out of bounds 에러
		//어차피 마지막 값은 0이므로 상관 없다 
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		ans=Integer.MAX_VALUE; //가장 긴 길이 
		int s=0;
		int e=0; 
		sum=arr[0]; //시작 
		while(e<N && s<=e) {
			if(sum<S) {
				//아직 S보다 작음 
				e++;
				sum+=arr[e]; 
			}
			else {
				//S이상 
				len=e-s+1;
				ans=Math.min(ans, len); //길이가 더 작다면 갱신 
				sum-=arr[s];
				s++;
			}
		}
		if(ans==Integer.MAX_VALUE) ans=0;
		System.out.println(ans);
	}

}
