import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long div = 1000000000;

        // 자릿수를 표현하는 N
        // 자릿수 0~9까지 표현
        long[][] dp = new long[N+1][10];

        // 1의자릿수는 모두 경우가 하나씩밖에 없음
        for (int i=1; i<=9; i++){
            dp[1][i] = 1;
        }

        // 두자릿수부터 계산
        for (int i=2; i<=N; i++){

            for (int j=0; j<=9; j++){

                // 해당 자릿값이 0이라면, 1밖에 경우가 없음
                if (j == 0)
                    dp[i][0] = dp[i-1][1] % div;

                // 해당 자릿값이 9라면, 8밖에 경우의 수가 없음
                else if (j == 9)
                    dp[i][9] = dp[i-1][8] % div;
                
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % div;
            }
        }
        
        long answer = 0;
        
        // 입력한 자릿수의 모든 경우의 수 합
        for (int i=0; i<10; i++){
            answer += dp[N][i];
        }

        System.out.println(answer%div);
    }
}
