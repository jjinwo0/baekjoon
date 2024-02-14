import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;
        int square = (int) Math.pow(2, N);

        while(true){
            square /= 2;

            if (r < square && c < square){
                answer += 0;
            } else if (r < square){
                answer += square * square;
                c -= square;
            } else if (c < square){
                answer += square * square * 2;
                r -= square;
            } else {
                answer += square * square * 3;
                r -= square;
                c -= square;
            }

            if (square <= 1) {
                System.out.println(answer);
                break;
            }
        }
    }
}
