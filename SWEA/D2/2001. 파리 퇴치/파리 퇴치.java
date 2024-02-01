import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for (int i=0; i<N-M+1; i++){
                for (int j=0; j<N-M+1; j++){

                    int sum = 0;

                    for (int n=0; n<M; n++){
                        for (int m=0; m<M; m++){
                            sum += map[i+n][j+m];
                        }
                    }

                    if (result < sum)
                        result = sum;
                }
            }

            System.out.println("#"+test_case+" "+result);
        }
    }
}
