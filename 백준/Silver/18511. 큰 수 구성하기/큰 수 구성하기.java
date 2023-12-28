import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


	private static int[] num;
	private static int N;
	private static int K;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		num = new int[K];
		for (int i = 0; i < K; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		dfs(0);
		System.out.println(ans);
	}

	private static void dfs(int now) {
		if(now>N) return;
		
		if(ans<now) ans=now;
		
		for (int i = K-1; i > -1; i--) {
			dfs(now*10+num[i]);
		}
	}

}