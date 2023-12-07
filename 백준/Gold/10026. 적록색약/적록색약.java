import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] graph;
    static boolean[][] check;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        check = new boolean[N][N];

        for (int i=0; i<N; i++){
            graph[i] = br.readLine().toCharArray();
        }

        int normal = 0;
        int blindness = 0;

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!check[i][j]){
                    dfs(i, j);
                    normal++;
                }
                if (graph[i][j] == 'G')
                    graph[i][j] = 'R';
            }
        }

        check = new boolean[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (!check[i][j]){
                    dfs(i, j);
                    blindness++;
                }
            }
        }

        System.out.println(normal + " " + blindness);
    }

    private static void dfs(int x, int y) {

        if (check[x][y])
            return;

        check[x][y] = true;
        char currentChar = graph[x][y];

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N){
                if (graph[nx][ny] == currentChar && !check[nx][ny])
                    dfs(nx, ny);
            }
        }
    }
}
