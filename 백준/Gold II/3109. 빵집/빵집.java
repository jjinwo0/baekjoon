import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;

    static int R, C;

    // 오른쪽 위, 오른쪽, 오른쪽 아래
    static int[] dX = {1, 1, 1};
    static int[] dY = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        int answer = 0;

        for (int i=0; i<R; i++){
            char[] arr = br.readLine().toCharArray();

            for (int j=0; j<C; j++){
                map[i][j] = arr[j];
            }
        }

        for (int i=0; i<R; i++){
            if (dfs(i, 0))
                answer++;
        }

        System.out.println(answer);
    }

    private static boolean dfs(int y, int x) {

        map[y][x] = 'o';

        if (x == C-1){
            return true;
        }

        for (int i=0; i<3; i++){
            int nY = y + dY[i];
            int nX = x + dX[i];

            if (nY >= 0 && nX >= 0 && nY < R && nX < C && map[nY][nX] == '.')
                if (dfs(nY, nX)) return true;
        }

        return false;
    }
}