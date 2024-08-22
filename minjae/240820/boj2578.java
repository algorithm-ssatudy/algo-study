import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2578 {
	static int line;
	static int[][] bingo = new int[5][5];
	static boolean[][] checked = new boolean[5][5];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//빙고 배열 완성
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		loop: for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				int b = Integer.parseInt(st.nextToken());
				makeBingo(b);
				if(checkBingo()) {
					System.out.println((i*5) + j + 1);
					break loop;
				}
			}
		}
		
	}
	
	static void makeBingo(int num) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(bingo[i][j] == num) {
					checked[i][j] = true;
				}
			}
		}
	}
	
	static boolean checkBingo() {
		int line = 0;
		
		// 가로 빙고 체크
		for(int i=0; i<5; i++) {
			boolean row_flag = true;
			for(int j=0; j<5; j++) {
				if(!checked[i][j]) {
					row_flag = false;
					break;
				}
			}
			if(row_flag) line++;
		}
	
		// 세로 빙고 체크
		for(int i=0; i<5; i++) {
			boolean col_flag = true;
			for(int j=0; j<5; j++) {
				if(!checked[j][i]) {
					col_flag = false;
					break;
				}
			}
			if(col_flag) line++;
		}
		
		// 대각선 빙고 체크
		boolean diag_flag = true;
		boolean diag_flag2 = true;
		for(int i=0; i<5; i++) {
			if(!checked[i][i]) {
				diag_flag = false;
			}
			
			if(!checked[i][5-i-1]) {
				diag_flag2 = false;
			}
		}
		
		if(diag_flag) line++;
		if(diag_flag2) line++;
		
		if(line >= 3) return true;
		return false;
	}
}
