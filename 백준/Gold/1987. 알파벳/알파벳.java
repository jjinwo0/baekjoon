import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int R, C, answer;
    static int[][] map;
    static boolean[] check;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new int[R][C];
        check = new boolean[26];

        for (int i=0; i<R; i++){
            String temp = br.readLine();
            for (int j=0; j<C; j++){
                map[i][j] = temp.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 1);

        System.out.println(answer);
    }

    private static void dfs(int y, int x, int count) {

        check[map[y][x]] = true;
        answer = Math.max(answer, count);

        for (int i=0; i<4; i++){
            int nY = y + dY[i];
            int nX = x + dX[i];

            if (nY >= 0 && nX >= 0 && nY < R && nX < C){
                if (!check[map[nY][nX]]) {

                    dfs(nY, nX, count + 1);
                }
            }
        }
        check[map[y][x]] = false;
    }
}
