import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N];
        int[] P = new int[N];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[N+1];

        for (int i=0; i<N; i++){
            int next = i + T[i]; // 다음날

            if (next <= N) // 다음날이 마지막날이기 전까지
                DP[next] = Math.max(DP[next], DP[i] + P[i]);

            DP[i+1] = Math.max(DP[i+1], DP[i]);
        }

        System.out.println(DP[N]);
    }
}
