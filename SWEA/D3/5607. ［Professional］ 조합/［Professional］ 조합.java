import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N, R;
    static long p = 1234567891;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){

            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            long[] factorial = new long[N + 1];
            factorial[0] = 1;

            for (int i=1; i<=N; i++){
                factorial[i] = (factorial[i-1] * i) % p;
            }

            long up = 1;
            long down = 1;

            up = factorial[N];
            down = (factorial[N-R] * factorial[R]) % p;
            down = div(down, p-2);

            sb.append((up * down) % p).append("\n");
        }
        System.out.println(sb);
    }

    public static long div(long a, long b){

        if (b == 0)
            return 1;

        if (b == 1)
            return a;

        if (b % 2 == 0) {
            long temp = div(a, b / 2);
            return (temp * temp) % p;
        }

        long temp = div(a, b-1) % p;

        return (temp * a) % p;
    }
}