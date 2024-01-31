import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int[][] map;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};
    static int size, count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case=1; test_case<=T; test_case++){

            size = Integer.parseInt(br.readLine());
            count = 0;

            map = new int[size][size];

            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    map[i][j] = 0;
                }
            }
            
            dfs(0, 0);

            System.out.println("#"+test_case);
            
            for (int i=0; i<size; i++){
                for (int j=0; j<size; j++){
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void dfs(int y, int x) {

        map[y][x] = ++count;

        for (int i=0; i<4; i++){

            int nY = y + dY[i];
            int nX = x + dX[i];

            if (nY < 0 || nX < 0 || nY >= size || nX >= size || map[nY][nX] != 0)
                continue;

            dfs(nY, nX);
        }
    }
}
