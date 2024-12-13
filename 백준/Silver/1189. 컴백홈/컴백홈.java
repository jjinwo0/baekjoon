import java.io.*;
import java.util.*;

public class Main {
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        backtrack(R-1, 0, 1);

        System.out.println(answer);
    }

    private static void backtrack(int x, int y, int distance) {
        if (x == 0 && y == C-1 && distance == K) {
            answer++;  
            return;
        }

        if (distance >= K)
            return;  

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C
                    && !visited[nx][ny] && map[nx][ny] != 'T') {
                backtrack(nx, ny, distance + 1);
            }
        }

        visited[x][y] = false;
    }
}