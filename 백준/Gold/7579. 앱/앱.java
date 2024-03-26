import java.io.*;
import java.util.*;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] memories = new int[N];
		int[] times = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memories[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		int dp[][] = new int[N][10001];
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10001; j++) {
				if (times[i] > j) {
					if(i==0) {
						dp[i][j]=0;
					}else {
						dp[i][j] = dp[i - 1][j];	
					}
				} else {
					if(i==0) {
						dp[i][j]=Math.max(0,  memories[i]);
					}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - times[i]] + memories[i]);
				}
				if(dp[i][j]>=M) {
					
					answer = Math.min(answer, j);
				}
			}
		}
	}
		System.out.println(answer);
	}
}
