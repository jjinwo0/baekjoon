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

            int[] snack = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++){
                snack[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;

            for (int i=0; i<N-1; i++){
                for (int j=i+1; j<N; j++){
                    int value = snack[i] + snack[j];

                    if ((max < value) && value <= M)
                        max = value;
                }
            }

            if (max == 0){
                System.out.println("#"+test_case+" -1");
                continue;
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
}