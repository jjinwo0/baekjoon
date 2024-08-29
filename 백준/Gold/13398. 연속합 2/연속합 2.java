import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][2];
        dp[1][0] = arr[1];
        dp[1][1] = arr[1];

        int answer = dp[1][0];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);  // 삭제하지 않은 최대값
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);  // 하나를 삭제한 최대값

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(answer);
    }
}