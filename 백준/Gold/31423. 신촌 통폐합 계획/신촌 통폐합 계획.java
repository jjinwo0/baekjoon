import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, I, J;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String[] univ = new String[N + 1];
        int[] next = new int[N + 1];
        int[] tail = new int[N + 1];

        for (int i = 1; i <= N; i++) {

            univ[i] = br.readLine();
            tail[i] = i;
        }

        StringTokenizer st;

        for (int i = 1; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            I = Integer.parseInt(st.nextToken());
            J = Integer.parseInt(st.nextToken());

            next[tail[I]] = J; // next[2] = 3, next[1] = 2, next[4] = 5, next[3] = 4
            tail[I] = tail[J]; // tail[2] = 3, tail[1] = 3, tail[4] = 5, tail[1] = 5
        }

        StringBuilder sb = new StringBuilder();

        while(I != 0){
            sb.append(univ[I]);
            I = next[I];
        }

        System.out.println(sb);
    }
}