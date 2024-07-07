import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] hp, happy;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //사람 수

        hp = new int[N+1];
        happy = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[101][N+1];

        for(int i=1; i<101; i++) { 
            for(int j=1; j<=N; j++) { 
                if(i > hp[j]) { 
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i-hp[j]][j-1] + happy[j]);
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        System.out.println(dp[100][N]);

    }
}