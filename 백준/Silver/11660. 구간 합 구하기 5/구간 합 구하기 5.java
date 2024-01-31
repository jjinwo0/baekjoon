import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][N+1];

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;

            for (int j=1; j<=N; j++){
                sum += Integer.parseInt(st.nextToken());
                arr[i][j] = sum;
            }
        }

        for (int i=0; i<M; i++){

            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;

            for (int m=x1; m<=x2; m++){
                sum += arr[m][y2] - arr[m][y1-1];
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb.toString());
    }
}
