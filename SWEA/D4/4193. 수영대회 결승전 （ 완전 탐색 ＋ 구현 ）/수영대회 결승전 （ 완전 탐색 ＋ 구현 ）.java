import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static class Player {

        int y;
        int x;
        int time;

        public Player(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int N, A, B, C, D;

    static int[][] map;

    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            sb.append("#").append(tc).append(" ");

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            Player player = new Player(A, B, 0);

            st = new StringTokenizer(br.readLine());

            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            bfs(player);
        }
        System.out.println(sb);
    }

    private static void bfs(Player player) {

        Queue<Player> queue = new LinkedList<>();

        queue.add(player);

        visited[player.y][player.x] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i=0; i<size; i++) {

                Player p = queue.poll();

                if (p.y == C && p.x == D) {
                    sb.append(p.time).append("\n");
                    return;
                }

                for (int k = 0; k < 4; k++) {
                    int ny = p.y + dy[k];
                    int nx = p.x + dx[k];

                    if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx] && map[ny][nx] != 1) {

                        if (map[ny][nx] == 2) {

                            if (p.time % 3 == 2){

                                visited[ny][nx] = true; // 방문 표시
                                queue.offer(new Player(ny, nx, p.time + 1));
                            } else queue.offer(new Player(p.y, p.x, p.time + 1));
                        }

                        else {
                            visited[ny][nx] = true; // 방문 표시
                            queue.offer(new Player(ny, nx, p.time + 1));
                        }
                    }
                }
            }
        }

        sb.append(-1).append("\n");
    }
}