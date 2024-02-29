import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];
        int[][] items = new int[N + 1][2];

        for (int i=1; i<=N; i++) {

            st = new StringTokenizer(br.readLine());

            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int k=1; k<=K; k++){
            for (int i=1; i<=N; i++){
                dp[i][k] = dp[i-1][k];

                if (k - items[i][0] >= 0)
                    dp[i][k] = Math.max(dp[i-1][k], items[i][1] + dp[i-1][k - items[i][0]]);
            }
        }

        System.out.println(dp[N][K]);
    }
}