import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Virus {
        int y;
        int x;
        int time;

        public Virus(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int N, M;

    static int[][] map;

    static boolean[][] visited;

    static int[][] selected;

    static ArrayList<int[]> startVirus;

    static Queue<Virus> queue;

    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};

    static int answer, zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        startVirus = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        selected = new int[M][2];
        zero = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2)
                    startVirus.add(new int[]{i, j});

                if (map[i][j] == 0)
                    zero++;
            }
        }

        if (zero == 0) {
            System.out.println(0);
            return;
        }

        combination(0, 0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }

    static void combination(int start, int depth) {
        if (depth == M) {
            queue = new LinkedList<>();
            visited = new boolean[N][N];
            bfs(zero);
            return;
        }
        for (int i = start; i < startVirus.size(); i++) {
            selected[depth] = startVirus.get(i);
            combination(i + 1, depth + 1);
        }
    }

    private static void bfs(int zeroCount) {

        for (int[] loc : selected) {
            queue.offer(new Virus(loc[0], loc[1], 0));
            visited[loc[0]][loc[1]] = true;
        }

        while (!queue.isEmpty()) {

            Virus virus = queue.poll();

            visited[virus.y][virus.x] = true;

            for (int i = 0; i < 4; i++) {
                int ny = virus.y + dy[i];
                int nx = virus.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] != 1 && !visited[ny][nx]) {

                    if (map[ny][nx] == 0)
                        zeroCount--;

                    queue.add(new Virus(ny, nx, virus.time + 1));
                    visited[ny][nx] = true;

                    if (zeroCount == 0){
                        answer = Math.min(answer, virus.time + 1);
                        return;
                    }
                }
            }
        }
    }
}