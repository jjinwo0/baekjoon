import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long answer = mult(A%C, B, C);

        System.out.println(answer);
    }

    private static long mult(long A, long B, long C) {

        if (B == 1){
            return A % C;
        }

        long temp = mult(A, B / 2, C) % C;

        if (B % 2 == 1)
            return (A * ((temp * temp) % C)) % C;

        return temp * temp % C;
    }
}