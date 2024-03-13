import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] students;

    static boolean[] visited, team;

    static int N, count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            N = Integer.parseInt(br.readLine());

            students = new int[N + 1];
            visited = new boolean[N + 1];
            team = new boolean[N + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) {
                if (!team[i])
                    dfs(i);
            }

            sb.append(N-count).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int index) {

        visited[index] = true;

        int next = students[index];

        if (!visited[next])
            dfs(next);

        else {

            if (!team[next]) {
                count++;

                while(next != index){
                    count++;
                    next = students[next];
                }
            }
        }

        team[index] = true;
    }
}