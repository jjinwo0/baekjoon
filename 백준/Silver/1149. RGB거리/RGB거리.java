import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int RED = Integer.parseInt(st.nextToken());
        int GREEN = Integer.parseInt(st.nextToken());
        int BLUE = Integer.parseInt(st.nextToken());

        dp[0][0] = RED;
        dp[0][1] = GREEN;
        dp[0][2] = BLUE;

        for (int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());

            RED = Integer.parseInt(st.nextToken());
            GREEN = Integer.parseInt(st.nextToken());
            BLUE = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RED;
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + GREEN;
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + BLUE;
        }

        System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
    }
}