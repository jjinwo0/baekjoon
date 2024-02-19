import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t=0; t<T; t++){

            int N = Integer.parseInt(br.readLine());

            int[] coins = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i=0; i<N; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[10001];

            dp[0] = 1;

            for (int i=0; i<N; i++){
                for (int j=coins[i]; j<=M; j++){
                    dp[j] += dp[j-coins[i]];
                }
            }

            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb);
    }
}
