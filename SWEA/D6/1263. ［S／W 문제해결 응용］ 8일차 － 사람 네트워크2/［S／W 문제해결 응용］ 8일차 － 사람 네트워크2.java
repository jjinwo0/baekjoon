import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int[][] dist = new int[N][N];

            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){

                    dist[i][j] = Integer.parseInt(st.nextToken());

                    if (i != j && dist[i][j] == 0) dist[i][j] = 100_000_000;
                }
            }

            for (int k=0; k<N; k++){

                for (int i=0; i<N; i++){
                    for (int j=0; j<N; j++){
                        dist[i][j] = Math.min(dist[i][j], dist[k][j] + dist[i][k]);
                    }
                }
            }

            int answer = Integer.MAX_VALUE;

            for (int i=0; i<N; i++){
                int temp = 0;

                for (int j=0; j<N; j++){
                    temp += dist[i][j];
                }
                answer = Math.min(answer, temp);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}