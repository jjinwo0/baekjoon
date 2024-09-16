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
        final int MOD = 1000000000;

        int[][] dp = new int[N + 1][K + 1];

        // Initialize dp array
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1; // Any number can be represented as the sum of exactly 1 integer in only one way
        }
        for (int i = 0; i <= K; i++) {
            dp[0][i] = 1; // The number 0 can be represented in exactly 1 way
        }

        // Fill the dp array
        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD; // Apply MOD to the entire sum
            }
        }

        System.out.println(dp[N][K]);
    }
}