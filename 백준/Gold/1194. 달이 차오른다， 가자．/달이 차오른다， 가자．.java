import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Minsik {
        int y;
        int x;
        int dist;
        int keys;

        public Minsik(int y, int x, int dist, int keys) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.keys = keys;
        }
    }

    static int N, M, answer = -1;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][1 << 6];

        Minsik minsik = null;

        for (int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for (int j=0; j<M; j++){
                if (map[i][j] == '0')
                    minsik = new Minsik(i, j, 0, 0);
            }
        }

        bfs(minsik);

        System.out.println(answer);
    }

    private static void bfs(Minsik minsik) {
        Queue<Minsik> queue = new LinkedList<>();
        queue.add(minsik);
        visited[minsik.y][minsik.x][minsik.keys] = true;

        while (!queue.isEmpty()) {
            Minsik now = queue.poll();

            if (map[now.y][now.x] == '1') {
                answer = now.dist;
                return;
            }

            for (int i=0; i<4; i++){
                int ny = now.y + dY[i];
                int nx = now.x + dX[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx][now.keys]) {
                    char loc = map[ny][nx];

                    if (loc == '#') continue;

                    if (loc >= 'a' && loc <= 'f') {
                        int newKeys = (now.keys | (1 << (loc - 'a')));
                        visited[ny][nx][newKeys] = true;
                        queue.add(new Minsik(ny, nx, now.dist + 1, newKeys));
                    } else if (loc >= 'A' && loc <= 'F') {
                        if ((now.keys & (1 << (loc - 'A'))) != 0) {
                            visited[ny][nx][now.keys] = true;
                            queue.add(new Minsik(ny, nx, now.dist + 1, now.keys));
                        }
                    } else {
                        visited[ny][nx][now.keys] = true;
                        queue.add(new Minsik(ny, nx, now.dist + 1, now.keys));
                    }
                }
            }
        }
        answer = -1;
    }
}