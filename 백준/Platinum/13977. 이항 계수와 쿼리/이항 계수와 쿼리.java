import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, R;
    static long p = 1000000007;

    static final int MAX = 4000000;
    static long[] factorial = new long[MAX + 1];
    static long[] divide = new long[MAX + 1];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 팩토리얼과 모듈러 역원 미리 계산
        factorial[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            factorial[i] = factorial[i - 1] * i % p;
        }

        divide[MAX] = div(factorial[MAX], p - 2);
        for (int i = MAX - 1; i >= 0; i--) {
            divide[i] = divide[i + 1] * (i + 1) % p;
        }


        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            if (N < R) {
                sb.append(0).append("\n");
                continue;
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