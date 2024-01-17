import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] check;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};
    static int n, m, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean isZero = true;
        arr = new int[n][m];
        check = new boolean[n][m];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1)
                    isZero = false;
            }
        }

        if (isZero){
            System.out.println("0");
            System.out.println("0");
            return;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count = 0; //////////////////// 1
                if (!check[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        System.out.println(answer.get(answer.size() - 1));
    }

    private static void dfs(int y, int x) {
        check[y][x] = true;
        count++;

        for (int i=0; i<4; i++) {
            int nY = y + dY[i];
            int nX = x + dX[i];

            if (nY >= 0 && nX >= 0 && nY < n && nX < m && !check[nY][nX] && arr[nY][nX] == 1){
                dfs(nY, nX);
            }
        }
    }
}
