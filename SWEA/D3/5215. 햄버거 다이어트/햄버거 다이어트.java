import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    static int ingredient[][], N, L, maxValue;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case=1; test_case<=T; test_case++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            maxValue = 0;

            ingredient = new int[N][2];
            visited = new boolean[N];

            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                ingredient[i][0] = Integer.parseInt(st.nextToken());
                ingredient[i][1] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, 0);

            System.out.println("#"+test_case+" "+maxValue);
        }
    }

    private static void dfs(int n, int value, int kcal) {

        // 유효한 값들의 모임
        if (kcal > L)
            return;

        maxValue = Math.max(maxValue, value);

        for (int i=n; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;

                dfs(i, value+ingredient[i][0], kcal+ingredient[i][1]);

                visited[i] = false;
            }
        }


    }
}