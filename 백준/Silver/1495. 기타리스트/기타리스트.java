import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, M, answer;

    static boolean[][] dp;

    static int[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = -1;

        V = new int[N + 1];
        dp = new boolean[N + 1][M + 1];

        dp[0][S] = true;

        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {

            V[i] = Integer.parseInt(st.nextToken());

            for (int n=0; n<=M; n++) {

                if (dp[i-1][n]) {

                    int high = n + V[i];
                    int low = n - V[i];

                    if (high <= M)
                        dp[i][high] = true;

                    if (low >= 0)
                        dp[i][low] = true;
                }
            }
        }

        for (int i=M; i>=0; i--) {
            if (dp[N][i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}