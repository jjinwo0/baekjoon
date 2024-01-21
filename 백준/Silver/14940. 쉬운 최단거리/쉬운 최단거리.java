import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map, distance;
    static int[] dX = {1, -1, 0, 0};
    static int[] dY = {0, 0, 1, -1};
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int startN = -1, startM = -1;

        map = new int[n][m];
        distance = new int[n][m];
        check = new boolean[n][m];

        for (int i=0; i<n; i++){

            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (startN < 0) {
                for (int j = 0; j < m; j++) {
                    int temp = map[i][j];

                    if (temp == 2) {
                        startN = i;
                        startM = j;

                        break;
                    }
                }
            }
        }

        bfs(startN, startM);

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (!check[i][j] && map[i][j] == 1)
                    sb.append(-1 + " ");

                else
                    sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int N, int M) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, M});
        check[N][M] = true;

        while(!queue.isEmpty()){

            int[] temp = queue.poll();

            for (int i=0; i<4; i++){

                int nX = dX[i] + temp[0];
                int nY = dY[i] + temp[1];

                if (nX < 0 || nY < 0 || nX >= n || nY >= m)
                    continue;
                if (map[nX][nY] == 0)
                    continue;
                if (check[nX][nY])
                    continue;

                queue.add(new int[]{nX, nY});
                distance[nX][nY] = distance[temp[0]][temp[1]] + 1;
                check[nX][nY] = true;
            }
        }
    }
}
