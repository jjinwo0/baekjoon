import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[D+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=D; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int A = 1;
        int B = 2;

        while(true) {

            /*
            A(1) -> B(2) -> A(1) + B(2) ->
            A(1) + 2B(4) -> 2A(2) + 3B(6) -> 3A(3) + 5B(10)
             */
            if ((K - dp[D - 3] * A) % dp[D - 2] == 0) {

                B = (K - dp[D-3] * A) / dp[D-2];
                break;
            }

            A++;
        }

        System.out.println(A);
        System.out.println(B);
    }
}