import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1890 {

	//점프
	static int N, map[][];
	static long dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		dp = new long[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==0) continue;
				int num=map[i][j];
				if(i+num<N) dp[i+num][j]+=dp[i][j];
				if(j+num<N) dp[i][j+num]+=dp[i][j];
			}
		}
		System.out.println(dp[N-1][N-1]);
	}

}
