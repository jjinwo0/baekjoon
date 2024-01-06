import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(calc(N));
    }

    private static int calc(int n) {

        int count = 0;

        if (n < 100)
            return n;

        else {
            for (int i=100; i<=n; i++){
                int a = i / 100;
                int b = (i / 10) % 10;
                int c = i % 10;

                if ((b-a) == (c-b))
                    count++;
            }
        }

        return count + 99;
    }
}
