import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] coins;

        for (int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());

            coins = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++){
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M + 1];
            dp[0] = 1;

            for (int coin : coins){
                for (int i=coin; i<=M; i++){
                    dp[i] += dp[i-coin];
                }
            }

            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}
