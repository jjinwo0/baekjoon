import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int idx = Math.abs(H - N);
        long[][] map = new long[idx+1][idx+1];

        for (int i=0; i<=idx; i++){
            for (int j=0; j<=idx; j++){
                if (j < i){
                    map[i][j] = 0;
                }else
                    map[i][j] = 1;
            }
        }

        for (int i=1; i<=idx; i++){

            for (int j=1; j<=idx; j++){
                if (j < i) continue;
                map[i][j] = map[i][j-1] + map[i-1][j];
            }
        }

        System.out.println(map[idx][idx]);

    }
}
