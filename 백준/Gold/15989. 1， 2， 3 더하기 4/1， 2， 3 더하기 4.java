import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][4];

        /*
        더해주는 숫자의 마지막 수를 이차원 배열의 index로 가져간다.
        [1][1] -> 1
        [2][1] -> 1 + 1 / [2][2] -> 2
        [3][1] -> 1 + 1 + 1 / [3][2] -> 1 + 2 / [3][3] -> 3
         */
        for (int i=1; i<=3; i++) {
            for (int j=1; j<=i; j++) {
                dp[i][j] = 1;
            }
        }

        /*
        4를 기준으로 보았을 때
        [4][1] : 3 + 1 -> dp[3][1] (n-1의 값에 + 1 한 경우의 수 밖에 없다.)
        [4][2] : 1 + 1 + 2, 2 + 2 -> dp[2][1] + dp[2][2] == 1 + 1
        [4][3] : 1 + 3 -> dp[1][1] + dp[1][2] + dp[1][3] == 1 + 0 + 0

        5를 기준으로 보았을 때
        [5][1] : 4 + 1 -> dp[4][1] == 1
        [5][2] : 1 + 1 + 1 + 2, 1 + 2 + 2 -> dp[3][1] + dp[3][2] == 1 + 1
        [5][3] : 1 + 1 + 3, 2 + 3 -> dp[2][1] + dp[2][2] + dp[2][3] == 1 + 1 + 0
         */

        for (int i=4; i<=10000; i++) {

            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for (int i=0; i<T; i++) {

            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
        }
    }
}