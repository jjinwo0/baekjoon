import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N + 1][N + 1];
        palindrome(arr, N);

        int M = Integer.parseInt(br.readLine());

        for (int i=0; i<M; i++){

            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if (dp[S][E])
                sb.append("1").append("\n");

            else sb.append("0").append("\n");
        }
        System.out.println(sb);
    }

    private static void palindrome(int[] arr, int n) {

        for (int i=1; i<=n; i++){
            dp[i][i] = true;
        }

        for (int i=1; i<n; i++){
            if (arr[i] == arr[i+1])
                dp[i][i+1] = true;
        }

        for(int i = 2; i < n; i++){
            for(int j = 1; j <= n - i; j++){
                if(arr[j] == arr[j + i] && dp[j + 1][j + i - 1])
                    dp[j][j + i] = true;
            }
        }
    }
}