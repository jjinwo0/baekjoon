import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int y;
        int x;
        int time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static char[][] map;

    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M, count, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = 0;
        max = 0;

        map = new char[N][M];

        for (int i=0; i<N; i++){
            char[] arr = br.readLine().toCharArray();

            for (int j=0; j<M; j++){
                map[i][j] = arr[j];
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (map[i][j] == 'L'){
                    visited = new boolean[N][M];
                    int time = bfs(i, j);
                    max = Math.max(max, time);
                }
            }
        }

        System.out.println(max);
    }

    private static int bfs(int y, int x) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(y, x, 0));

        visited[y][x] = true;

        int time = 0;

        while(!queue.isEmpty()){

            Node poll = queue.poll();

            for (int i=0; i<4; i++){
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx] && map[ny][nx] == 'L'){

                    queue.offer(new Node(ny, nx, poll.time + 1));
                    time = Math.max(time, poll.time + 1);
                    visited[ny][nx] = true;
                }
            }
        }

        return time;
    }
}