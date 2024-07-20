import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

//    public static class Gahui {
//
//        int y;
//        int x;
//        int count;
//        int time;
//
//        public Gahui(int y, int x, int count, int time) {
//            this.y = y;
//            this.x = x;
//            this.count = count;
//            this.time = time;
//        }
//    }

    static int[] dy = {0, 1, 0, -1, 0};
    static int[] dx = {1, 0, -1, 0, 0};

    static boolean[][][] visited;

    static char[][] map;

    static int R, C, T, answer;

//    static Gahui gahui;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        answer = 0;
        visited = new boolean[T + 1][R][C];
        map = new char[R][C];

        for (int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();

//            for (int j=0; j<C; j++){
//
//                if (map[i][j] == 'G') {
//                    gahui = new Gahui(i, j, 0, 0);
//                    map[i][j] = '.';
//                }
//            }
        }

        find();

//        bfs();

        System.out.println(answer);
    }

    private static void find() {

        for (int i = 0; i < R; i++) {
            for (int j=0; j < C; j++) {

                if (map[i][j] == 'G'){
                    map[i][j] = '.';
                    backtracking(i, j, 0, 0);
                }
            }
        }
    }

    private static void backtracking(int y, int x, int count, int time) {

        if (time == T){
            answer = Math.max(answer, count);
            return;
        }

        for (int i=0; i<5; i++){

            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && ny < R && nx < C && map[ny][nx] != '#'){

                if (map[ny][nx] == 'S'){
                    map[ny][nx] = '.';
                    backtracking(ny, nx, count + 1, time + 1);
                    map[ny][nx] = 'S';
                } else {
                    backtracking(ny, nx, count, time + 1);
                }
            }
        }
    }

//    private static void bfs() {
//
//        Queue<Gahui> queue = new LinkedList<>();
//        queue.offer(gahui);
//        visited[0][gahui.y][gahui.x] = true;
//
//        while (!queue.isEmpty()){
//
//            Gahui now = queue.poll();
//
//            if (now.time == T) {
//                answer = Math.max(now.count, answer);
//                continue;
//            }
//
//            for (int i=0; i<5; i++) {
//
//                int ny = now.y + dy[i];
//                int nx = now.x + dx[i];
//
//                if (now.time + 1 <= T && ny >= 0 && nx >= 0 && ny < R && nx < C && !visited[now.time + 1][ny][nx] && map[ny][nx] != '#'){
//
//                    int newCount = now.count;
//
//                    if (map[ny][nx] == 'S')
//                        newCount += 1;
//
//                    queue.offer(new Gahui(ny, nx, newCount, now.time + 1));
//                    visited[now.time + 1][ny][nx] = true;
//                }
//            }
//        }
//    }
}