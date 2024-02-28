import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        dp  = new int[30][30];

        for (int i=0; i<T; i++){

            for (int k=0; k<30; k++){
                dp[k][0] = 1;
                dp[k][1] = 1;
            }

            for (int k=2; k<30; k++){
                for (int j=1; j<30; j++){
                    dp[k][j] = dp[k-1][j-1] + dp[k-1][j];
                }
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(dp[M][N]).append("\n");
        }

        System.out.println(sb);
    }
}