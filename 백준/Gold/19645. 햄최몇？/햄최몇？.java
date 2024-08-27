import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] hamburger = new int[N + 1];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            hamburger[i] = Integer.parseInt(st.nextToken());
            sum += hamburger[i];
        }

        boolean[][] dp = new boolean[sum + 1][sum + 1];
        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = sum; j >= 0; j--) {
                for (int k = sum; k >= 0; k--) {
                    if (j - hamburger[i] >= 0 && dp[j - hamburger[i]][k]) {
                        dp[j][k] = true;
                    }
                    if (k - hamburger[i] >= 0 && dp[j][k - hamburger[i]]) {
                        dp[j][k] = true;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= i; j++) {
                int current = sum - i - j;
                if (dp[i][j] && i >= current && j >= current) {
                    answer = Math.max(answer, current);
                }
            }
        }

        System.out.println(answer);
    }
}