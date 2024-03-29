import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n+1][n+1];

        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){

                if (i == j) {
                    dist[i][j] = 0;
                    continue;
                }

                dist[i][j] = 100_000_000;
            }
        }

        for (int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], weight);
        }

        for (int k=1; k<=n; k++){

            for (int i=1; i<=n; i++){
                for (int j=1; j<=n; j++){

                    dist[i][j] = Math.min(dist[i][j], dist[k][j] + dist[i][k]);
                }
            }
        }

        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if (dist[i][j] == 100_000_000)
                    System.out.print(0 + " ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}