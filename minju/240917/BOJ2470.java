import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

	static int N, arr[], ans[];
	static long res=Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		ans=new int[2];
		N=Integer.parseInt(str.nextToken());
		arr=new int[N];
		str = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(str.nextToken());
		}
		Arrays.sort(arr);
		int st=0;
		int en=N-1;
		//st는 증가, en은 감소 
		while(st<en) {
			int sum=arr[st]+arr[en];
			if(Math.abs(sum)<res) {
				res=Math.abs(sum);
				ans[0]=arr[st];
				ans[1]=arr[en];
			}
			if(sum<0) {
				st++;
			}
			else {
				en--;
			}
		}
		System.out.println(ans[0]+" "+ans[1]);

	
	}

}
