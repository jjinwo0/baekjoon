import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Warrior {
        int y;
        int x;
        int time;
        boolean hasSword;

        public Warrior(int y, int x, int time, boolean hasSword) {
            this.y = y;
            this.x = x;
            this.time = time;
            this.hasSword = hasSword;
        }
    }

    static int N, M, T, answer;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        if (answer == Integer.MAX_VALUE) {
            System.out.println("Fail");
        } else {
            System.out.println(answer);
        }
    }

    private static void bfs() {

        Queue<Warrior> queue = new LinkedList<>();

        queue.offer(new Warrior(0, 0, 0, map[0][0] == 2));
        visited[0][0][map[0][0] == 2 ? 1 : 0] = true;

        while(!queue.isEmpty()){

            Warrior warrior = queue.poll();

            if (warrior.y == N-1 && warrior.x == M-1){
                if (warrior.time <= T)
                    answer = Math.min(answer, warrior.time);
            }

            for (int k=0; k<4; k++){
                int ny = dy[k] + warrior.y;
                int nx = dx[k] + warrior.x;
                int swordStatus = warrior.hasSword ? 1 : 0;

                if (ny >= 0 && nx >= 0 && ny < N && nx < M && !visited[ny][nx][swordStatus]){

                    visited[ny][nx][swordStatus] = true;
                    if (warrior.hasSword || map[ny][nx] != 1){
                        queue.offer(new Warrior(ny, nx, warrior.time + 1, warrior.hasSword || map[ny][nx] == 2));
                    }
                }
            }
        }
    }
}