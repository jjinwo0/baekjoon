import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] map;

    static boolean[] visited;

    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++){

            N = Integer.parseInt(br.readLine());

            map = new int[N+2][2];
            visited = new boolean[N+2];

            StringTokenizer st = new StringTokenizer(br.readLine());

            // Company
            map[0][0] = Integer.parseInt(st.nextToken());
            map[0][1] = Integer.parseInt(st.nextToken());

            // Home
            map[N+1][0] = Integer.parseInt(st.nextToken());
            map[N+1][1] = Integer.parseInt(st.nextToken());

            for (int i=1; i<=N; i++){
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }

            answer = Integer.MAX_VALUE;

            dfs(0, 0, 0);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int index, int count, int sum) {

        if (sum > answer)
            return;

        if (count == N){

            sum += Math.abs(map[index][0]-map[N+1][0]) + Math.abs(map[index][1]-map[N+1][1]);

            if (answer > sum)
                answer = sum;

            return;
        }

        for (int i=1; i<=N; i++){
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, count + 1, sum + Math.abs(map[index][0] - map[i][0]) + Math.abs(map[index][1] - map[i][1]));
                visited[i] = false;
            }
        }
    }
}