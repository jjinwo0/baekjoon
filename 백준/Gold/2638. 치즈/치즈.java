import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Cheeze {

        int y;
        int x;

        public Cheeze(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, answer;

    static int[][] map;

    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<Cheeze> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new int[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1)
                    queue.offer(new Cheeze(i, j));
            }
        }

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {

        while(!queue.isEmpty()){

            answer += 1;
            visited = new boolean[N][M];

            checkAir(0, 0);

            int size = queue.size();

            for (int i=0; i<size; i++){
                Cheeze poll = queue.poll();
                int count = 0;

                for (int k=0; k<4; k++){
                    int ny = poll.y + dy[k];
                    int nx = poll.x + dx[k];

                    if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 3)
                        count++;
                }

                if (count < 2)
                    queue.offer(poll);

                else map[poll.y][poll.x] = 0;
            }
        }
    }

    private static void checkAir(int y, int x) {

        visited[y][x] = true;
        map[y][x] = 3;

        for (int k=0; k<4; k++){

            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx] && map[ny][nx] != 1 && map[ny][nx] != 2)
                checkAir(ny, nx);
        }
    }
}