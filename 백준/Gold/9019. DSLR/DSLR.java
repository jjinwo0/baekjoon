import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] commands = new String[10000];

            queue.offer(A);
            visited[A] = true;
            Arrays.fill(commands, "");

            while(!queue.isEmpty() && !visited[B]){

                Integer poll = queue.poll();

                int D = (poll * 2) % 10000;
                int S = poll == 0 ? 9999 : poll - 1;
                int L = (poll % 1000) * 10 + poll / 1000;
                int R = (poll % 10) * 1000 + poll / 10;

                if (!visited[D]){

                    queue.offer(D);
                    visited[D] = true;
                    commands[D] = commands[poll] + "D";
                }

                if (!visited[S]){

                    queue.offer(S);
                    visited[S] = true;
                    commands[S] = commands[poll] + "S";
                }

                if (!visited[L]){

                    queue.offer(L);
                    visited[L] = true;
                    commands[L] = commands[poll] + "L";
                }

                if (!visited[R]){

                    queue.offer(R);
                    visited[R] = true;
                    commands[R] = commands[poll] + "R";
                }
            }

            System.out.println(commands[B]);
        }
    }
}