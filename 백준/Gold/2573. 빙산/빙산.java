import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Ice {
        int y;
        int x;

        public Ice(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[][] map;

    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while(true) {

            int count = checkIce();

            if (count >= 2) break;
            else if (count == 0) {
                year = 0;
                break;
            }

            bfs();
            year++;
        }

        System.out.println(year);
    }

    private static void bfs() {

        Queue<Ice> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    queue.add(new Ice(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Ice ice = queue.poll();

            int water = 0;

            for (int i = 0; i < 4; i++) {
                int nx = ice.x + dx[i];
                int ny = ice.y + dy[i];

                if (nx >= 0 && ny < N && ny >= 0 && nx < M) {
                    if (!visited[ny][nx] && map[ny][nx] == 0) {
                        water++;
                    }
                }
            }

            if (map[ice.y][ice.x] - water < 0) {
                map[ice.y][ice.x] = 0;
            } else {
                map[ice.y][ice.x] -= water;
            }
        }
    }

    private static int checkIce() {

        boolean[][] visited = new boolean[N][M];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private static void dfs(int y, int x, boolean[][] visited) {

        visited[y][x] = true;

        for (int i=0; i<4; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && ny < N && nx < M && !visited[ny][nx] && map[ny][nx] > 0) {
                dfs(ny, nx, visited);
            }
        }
    }
}