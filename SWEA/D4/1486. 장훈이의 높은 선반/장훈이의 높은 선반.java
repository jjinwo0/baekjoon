import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N, B;

    static int[] workers;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){

            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            workers = new int[N];
            answer = Integer.MAX_VALUE;

            workers = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            dfs(0, 0);

            sb.append(answer - B).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int height) {

        if (height >= B){
            answer = Math.min(answer, height);
            return;
        }

        if (depth == N)
            return;

        dfs(depth + 1, height); // 현재 depth의 직원을 포함하지 않는 경우
        dfs(depth + 1, height + workers[depth]); // 현재 depth의 직원을 포함하는 경우
    }
}
