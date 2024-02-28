import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K, W, H;

    static int[][] map;

    static boolean[][][] visited;

    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};

    static int[] kx = {1, 2, 2, 1, -1, -2, -2, -1};

    static int[] ky = {2, 1, -1, -2, -2, -1, 1, 2};

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        answer = -1;

        for (int i=0; i<H; i++){

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (W == 1 && H == 1){
            System.out.println(0);
            return;
        }

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 0, K});

        visited[0][0][K] = true;

        while(!queue.isEmpty()){

            int[] poll = queue.poll();

            int y = poll[0];
            int x = poll[1];
            int dist = poll[2];
            int k = poll[3];

            for (int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny == H-1 && nx == W-1){
                    answer = dist + 1;
                    return;
                }

                if (ny >= 0 && nx >= 0 && ny < H && nx < W && !visited[ny][nx][k] && map[ny][nx] == 0){
                    visited[ny][nx][k] = true;
                    queue.offer(new int[]{ny, nx, dist + 1, k});
                }
            }

            if (k > 0) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + ky[i];
                    int nx = x + kx[i];

                    if (ny == H-1 && nx == W-1){
                        answer = dist + 1;
                        return;
                    }

                    if (ny >= 0 && nx >= 0 && ny < H && nx < W && !visited[ny][nx][k - 1] && map[ny][nx] == 0) {
                        visited[ny][nx][k - 1] = true;
                        queue.offer(new int[]{ny, nx, dist + 1, k - 1});
                    }
                }
            }
        }
    }
}