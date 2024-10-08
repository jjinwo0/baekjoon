import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];

        for (int i=1; i<=N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) + map[i-1][j] + map[i][j-1] - map[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i=0; i<K; i++) {

            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int answer = map[r2][c2] - map[r1-1][c2] - map[r2][c1-1] + map[r1-1][c1-1];

            System.out.println(answer);
        }
    }
}