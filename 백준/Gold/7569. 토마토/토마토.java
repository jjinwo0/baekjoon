import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Tomato {
        int h;
        int y;
        int x;
        int time;

        public Tomato(int h, int y, int x, int time) {
            this.h = h;
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int N, M, H, answer;

    static int[][][] map;

    static boolean[][][] visited;

    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static ArrayList<Tomato> tomatoList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        visited = new boolean[H][N][M];
        tomatoList = new ArrayList<>();
        answer = -1;

        for (int h=0; h<H; h++){
            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<M; j++){
                    map[h][i][j] = Integer.parseInt(st.nextToken());

                    if (map[h][i][j] == 1)
                        tomatoList.add(new Tomato(h, i, j, 0));
                }
            }
        }

        if (check()){
            System.out.println(0);
            return;
        }

        bfs();
    }

    private static boolean check() {

        for (int h=0; h<H; h++){
            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    if (map[h][i][j] == 0)
                        return false;
                }
            }
        }

        return true;
    }

    private static void bfs() {

        Queue<Tomato> queue = new LinkedList<>();

        for (Tomato t : tomatoList)
            queue.offer(t);


        while (!queue.isEmpty()) {

            Tomato tomato = queue.poll();

            if (tomato.time > answer)
                answer = tomato.time;

            visited[tomato.h][tomato.y][tomato.x] = true;

            for (int i=0; i<6; i++){

                int nh = dh[i] + tomato.h;
                int ny = dy[i] + tomato.y;
                int nx = dx[i] + tomato.x;

                if (nh >= 0 && nh < H &&
                    ny >= 0 && ny < N &&
                    nx >= 0 && nx < M &&
                    !visited[nh][ny][nx] && map[nh][ny][nx] == 0){
                    map[nh][ny][nx] = 1;
                    queue.offer(new Tomato(nh, ny, nx, tomato.time + 1));
                    visited[nh][ny][nx] = true;
                }
            }
        }

        if (!check())
            System.out.println(-1);

        else System.out.println(answer);
    }
}