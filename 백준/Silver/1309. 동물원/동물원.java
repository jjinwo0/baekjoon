import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
        [0] : N번째 라인에 사자를 두지 않았을 때
        [1] : N번째 라인 왼쪽 칸에 사자를 두었을 때
        [2] : N번째 라인 오른쪽 칸에 사자를 두었을 때
         */
        long[][] dp = new long[N + 1][3];

        // 첫 시작을 1로 통일 (어디든 둘 수 있음)
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i=2; i<=N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901; // 이전 라인에 사자를 두지 않았을때, 왼쪽에 두었을 때, 오른쪽에 두었을 때 모두 가능
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901; // 이전 라인에서 왼쪽에 둔 경우를 제외하고 모두 합
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901; // 이전 라인에서 오른쪽에 둔 경우를 제외하고 모두 합
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2])%9901);
    }
}
