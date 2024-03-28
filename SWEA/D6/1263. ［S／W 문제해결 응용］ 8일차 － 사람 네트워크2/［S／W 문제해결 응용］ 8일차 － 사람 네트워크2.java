import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] board = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					board[i][j]=Integer.parseInt(st.nextToken());
					if(board[i][j]==0) {
						board[i][j]=1000000000;
					}
				}
			}
			for(int k=0;k<n;k++) {
				for(int i =0; i<n;i++) {
					if(k==i) continue;
					for(int j=0;j<n;j++) {
						if(j==k||i==j) continue;
						board[i][j]= Math.min(board[i][k]+board[k][j],board[i][j]);
					}
				}
			}
			int answer = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				int temp=0;
				for(int j=0;j<n;j++) {
					if(i==j) continue;
					temp+=board[i][j];
				}
				answer = Math.min(answer, temp);
			}
			System.out.printf("#%d %d\n",t,answer);
		}
		
		
		
	}
	
}
