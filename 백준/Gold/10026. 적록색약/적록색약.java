import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, count, blind;

    static char[][] map;

    static boolean[][] check;

    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        check = new boolean[N][N];

        for (int i=0; i<N; i++){
            char[] charArray = br.readLine().toCharArray();

            for (int j=0; j<N; j++) {
                map[i][j] = charArray[j];
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(!check[i][j]) {
                    dfs(i, j);
                    count++;
                }

                if (map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }

        check = new boolean[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if(!check[i][j]) {
                    dfs(i, j);
                    blind++;
                }
            }
        }

        sb.append(count).append(" ").append(blind);

        System.out.println(sb);
    }

    private static void dfs(int y, int x) {

        char c = map[y][x];

        check[y][x] = true;

        for (int i=0; i<4; i++){
            int nY = y + dY[i];
            int nX = x + dX[i];

            if (nY >= 0 && nX >= 0 && nY < N && nX < N && !check[nY][nX] && map[nY][nX] == c)
                dfs(nY, nX);
        }
    }
}