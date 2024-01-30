import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] dX = {-1, 1, 0};
    static int[] dY = {0, 0, -1};

    static int[][] map;

    static boolean[][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i=0; i<10; i++){

            int test_case = Integer.parseInt(br.readLine());

            map = new int[100][100];
            check = new boolean[100][100];

            int startX = 0, startY = 0;

            for (int n=0; n<map.length; n++){

                st = new StringTokenizer(br.readLine());

                for (int m=0; m<map[n].length; m++){
                    map[n][m] = Integer.parseInt(st.nextToken());

                    if (map[n][m] == 2){
                        startY = n;
                        startX = m;
                    }
                }
            }

            System.out.println("#"+test_case+" "+dfs(startY, startX));
        }
    }

    private static int dfs(int y, int x) {

        check[y][x] = true;

        if (y == 0)
            return x;

        for (int i=0; i<3; i++){

            int nY = y + dY[i];
            int nX = x + dX[i];

            if (nY < 0 || nX < 0 || nY >= 100 || nX >= 100 || map[nY][nX] == 0 || check[nY][nX])
                continue;

            return dfs(nY, nX);
        }

        return -1;
    }
}
