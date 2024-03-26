import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int y;
        int x;
        int roopy;

        public Node(int y, int x, int roopy) {
            this.y = y;
            this.x = x;
            this.roopy = roopy;
        }

        @Override
        public int compareTo(Node o) {
            return this.roopy - o.roopy;
        }
    }

    static int[][] map, answer;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        while (true) {

            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            map = new int[N][N];
            visited = new boolean[N][N];
            answer = new int[N][N];

            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    answer[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, map[0][0]));

            while (!pq.isEmpty()) {
                Node poll = pq.poll();

                if (visited[poll.y][poll.x]) continue;
                visited[poll.y][poll.x] = true;

                for (int i = 0; i < 4; i++) {
                    int ny = poll.y + dy[i];
                    int nx = poll.x + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx] && answer[ny][nx] > poll.roopy + map[ny][nx]) {
                        answer[ny][nx] = poll.roopy + map[ny][nx];
                        pq.offer(new Node(ny, nx, answer[ny][nx]));
                    }
                }
            }
            sb.append("Problem " + cnt++ + ": " + answer[N - 1][N - 1]).append("\n");

        }
        System.out.println(sb);
    }
}