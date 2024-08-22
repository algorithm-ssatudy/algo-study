import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17276 {
	static int n;
	static int[][] arr, temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tc = Integer.parseInt(st.nextToken());
		
		for(int t=0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			arr = new int[n][n];
			temp = new int[n][n];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					temp[i][j] = arr[i][j];
				}
			}
			
			// 360도 회전일 경우 출력 후 패스
			if(d % 360 == 0) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						sb.append(arr[i][j] + " ");
					}
					sb.append('\n');
				}
				System.out.print(sb);
				continue;
			}
			
			d /= 45;
			
			if(d < 0) {
				d *= -1;
				for(int i=0; i<d; i++)
					r_rotate();
			}
			else {
				for(int i=0; i<d; i++)
					rotate();
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append('\n');
			}
			System.out.print(sb);
		}
	}
	
	// 시계 방향 회전
	static void rotate() {
		for(int i=0; i<n; i++) {
			temp[i][n/2] = arr[i][i];
			temp[i][i] = arr[n/2][i];
			temp[n/2][i] = arr[n-i-1][i];
			temp[n-i-1][i] = arr[n-i-1][n/2];
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
	
	
	// 반시계 방향 회전
	static void r_rotate() {
		for(int i=0; i<n; i++) {
			temp[i][n/2] = arr[i][n-i-1];
			temp[i][i] = arr[i][n/2];
			temp[n/2][i] = arr[i][i];
			temp[n-i-1][i] = arr[n/2][i];
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
}
