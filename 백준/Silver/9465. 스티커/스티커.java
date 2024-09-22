import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {

            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for (int k=0; k<2; k++) {

                String[] input = br.readLine().split(" ");

                for (int len=1; len<=input.length; len++) {

                    map[k][len] = Integer.parseInt(input[len-1]);
                }
            }

            dp[0][1] = map[0][1];
            dp[1][1] = map[1][1];

            for (int col=2; col<=n; col++) {

                dp[0][col] = Math.max(dp[1][col-2], dp[1][col-1]) + map[0][col];
                dp[1][col] = Math.max(dp[0][col-2], dp[0][col-1]) + map[1][col];
            }

            int answer = Math.max(dp[0][n], dp[1][n]);

            System.out.println(answer);
        }
    }
}