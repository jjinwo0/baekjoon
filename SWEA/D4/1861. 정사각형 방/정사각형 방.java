import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] map;
    static int N;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};
    static int max = 0;
    static int maxY, maxX, in;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case=1; test_case<=T; test_case++){

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            maxX = 0; maxY = 0;
            max = 0; in = 0;

            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++) {
                    dfs(i, j, 1, i, j);
                }
            }

            System.out.println("#"+test_case+" "+map[maxY][maxX]+" "+max);
        }
    }

    private static void dfs(int y, int x, int count, int startY, int startX) {

        if (max == count && (map[startY][startX] < map[maxY][maxX])){

            maxY = startY; maxX = startX;
        }

        if (max < count) {
            maxY = startY; maxX = startX;
            max = count;
        }

        for (int i=0; i<4; i++){
            int nY = y + dY[i];
            int nX = x + dX[i];

            if (nY < 0 || nX < 0 || nY >= N || nX >= N)
                continue;

            if (map[nY][nX] == map[y][x] + 1)
                dfs(nY, nX, count + 1, startY, startX);
        }
    }
}