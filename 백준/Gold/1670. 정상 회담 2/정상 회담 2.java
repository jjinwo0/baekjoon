import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        dp[0] = 1;
        dp[2] = 1;

        for (int i=4; i<=N; i+=2){
            for (int j=0; j<=i-2; j+=2){
                dp[i] += dp[i-j-2] * dp[j];
                dp[i] %= 987654321;
            }
        }

        System.out.println(dp[N]);
    }
}