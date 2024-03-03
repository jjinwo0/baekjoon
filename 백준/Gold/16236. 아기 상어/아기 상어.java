import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Node o) {

            if (this.y == o.y)
                return Integer.compare(this.x, o.x);

            return Integer.compare(this.y, o.y);
        }
    }

    static int[][] map;

    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int sharkX, sharkY, size = 2, N, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        time = 0;

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                    map[i][j] = 0;
                }
            }
        }

        bfs(sharkY, sharkX);

        System.out.println(time);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N][N];
        PriorityQueue<Node> fishes = new PriorityQueue<>();

        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        int eat = 0;
        int dist = 0;

        while(!queue.isEmpty()) {
            int qsize = queue.size( );
            dist += 1;

            for (int s=0; s<qsize; s++){
                int[] poll = queue.poll();

                for (int i=0; i<4; i++){
                    int ny = poll[0] + dy[i];
                    int nx = poll[1] + dx[i];

                    if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
                        visited[ny][nx] = true;

                        if (map[ny][nx] <= size) {
                            queue.offer(new int[]{ny, nx});
                            if (map[ny][nx] > 0 && map[ny][nx] < size)
                                fishes.offer(new Node(ny, nx));
                        }
                    }
                }
            }

            if (!fishes.isEmpty()){
                Node poll = fishes.poll();
                eat += 1;
                map[poll.y][poll.x] = 0;
                time += dist;
                dist = 0;

                if (eat == size) {
                    size += 1;
                    eat = 0;
                }

                queue.clear();
                fishes.clear();
                queue.offer(new int[]{poll.y, poll.x});
                visited = new boolean[N][N];
                visited[poll.y][poll.x] = true;
            }
        }
    }
}