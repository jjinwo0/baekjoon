import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int[][] dp = new int[N][2];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(Math.max(arr[0][0], arr[0][1]));
            return;
        }

        dp[0][0] = arr[0][1];
        dp[0][1] = arr[0][0];

        for (int i=1; i<N; i++){

            dp[i][0] = Math.max(dp[i-1][0] + arr[i][1] + Math.abs(arr[i-1][0]-arr[i][0]),
                    dp[i-1][1] + arr[i][1] + Math.abs(arr[i-1][1]-arr[i][0]));

            dp[i][1] = Math.max(dp[i-1][0] + arr[i][0] + Math.abs(arr[i-1][0]-arr[i][1]),
                    dp[i-1][1] + arr[i][0] + Math.abs(arr[i-1][1]-arr[i][1]));
        }

        System.out.println(Math.max(dp[N-1][0], dp[N-1][1]));
    }
}

