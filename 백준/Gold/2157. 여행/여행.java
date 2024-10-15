import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] scoreBoard = new int[N+1][N+1];		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			scoreBoard[a][b] = Math.max(scoreBoard[a][b], c);
		}
		int[][] dp = new int[M+1][N+1];
		for (int i = 0; i <= M; i++) {
			Arrays.fill(dp[i],Integer.MIN_VALUE);
		}
		dp[1][1] = 0;
		
		
		for (int i = 1; i <= M; i++) { // i개의 도시를 지남
			for (int j = 1; j <= N; j++) { // j번째 도시에 대해
				for (int k = 1; k < j; k++) { // j번째 도시로 올 수 있는 경우를 확인해봄
					if(scoreBoard[j-k][j] == 0 || dp[i-1][j-k] == Integer.MIN_VALUE) continue;
                    // i-1개의 도시를 거친 상태에서 j-k도시에서 j로 이동
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-k]+scoreBoard[j-k][j]);
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i <=M; i++) {
			answer = Math.max(dp[i][N], answer);
		}
//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}

		System.out.println(answer);
	}
}