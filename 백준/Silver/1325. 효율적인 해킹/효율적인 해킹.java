import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(B).add(A);
        }

        answer = new int[N + 1];
        int max = Integer.MIN_VALUE;

        for (int i=1; i<=N; i++) {

            bfs(i, N);
        }

        for (int i=1; i<=N; i++)
            max = Math.max(max, answer[i]);

        for (int i = 1; i <= N; i++) {

            if (answer[i] == max)
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    private static void bfs(int i, int N) {

        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        while(!queue.isEmpty()) {

            Integer poll = queue.poll();

            for (int n : list.get(poll)) {

                if (!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                    answer[i]++;
                }
            }
        }
    }
}