import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println((fibo(b+2) - fibo(a+1) + MOD) % MOD);
    }

    private static long fibo(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long[][] F = {{1, 1}, {1, 0}};
        power(F, n - 1);

        return F[0][0];
    }

    private static void multiply(long[][] F, long[][] M) {
        long x = (F[0][0] * M[0][0] + F[0][1] * M[1][0]) % MOD;
        long y = (F[0][0] * M[0][1] + F[0][1] * M[1][1]) % MOD;
        long z = (F[1][0] * M[0][0] + F[1][1] * M[1][0]) % MOD;
        long w = (F[1][0] * M[0][1] + F[1][1] * M[1][1]) % MOD;

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;
    }

    private static void power(long[][] F, long n) {
        if( n == 0 || n == 1)
            return;
        long[][] M = {{1, 1}, {1, 0}};

        power(F, n / 2);
        multiply(F, F);

        if (n % 2 != 0)
            multiply(F, M);
    }
}