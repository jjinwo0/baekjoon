import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R1 = Integer.parseInt(st.nextToken());
        int C1 = Integer.parseInt(st.nextToken());
        int R2 = Integer.parseInt(st.nextToken());
        int C2 = Integer.parseInt(st.nextToken());

        String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        int cal = N * 2 - 1;

        for (int i = R1; i <= R2; i++) {
            for (int j = C1; j <= C2; j++) {
                int nr = i % cal;
                int nc = j % cal;
                int d = Math.abs(N - 1 - nr) + Math.abs(N - 1 - nc);

                if (d > N - 1)
                    System.out.print(".");
                else System.out.print((char)(d%26 + 97));

            }
            System.out.println();
        }
    }
}