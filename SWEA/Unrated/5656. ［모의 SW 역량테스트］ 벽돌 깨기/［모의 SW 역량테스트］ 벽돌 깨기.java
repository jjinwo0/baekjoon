import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N, W, H, answer;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){

            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            answer = Integer.MAX_VALUE;

            int[][] map = new int[H][W];

            for (int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (blockCount(map) == 0) {
                sb.append(0).append("\n");
                continue;
            }

            breakBlock(0, map);

            if (answer == Integer.MAX_VALUE)
                sb.append(0).append("\n");

            else sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static int blockCount(int[][] map) {

        int count = 0;

        for (int i=0; i<H; i++){
            for (int j=0; j<W; j++){
                if (map[i][j] != 0)
                    count++;
            }
        }

        return count;
    }

    private static void breakBlock(int n, int[][] map) {

        if (n == N) {
            answer = Math.min(answer, blockCount(map));
            return;
        }

        for (int j=0; j<W; j++){

            int[][] chMap = copy(map);

            for (int i=0; i<H; i++){
                if (chMap[i][j] != 0){

                    dfs(i, j, chMap);
                    dropBlocks(chMap);
                    breakBlock(n+1, chMap);

                    break;
                }
            }
        }
    }

    private static void dropBlocks(int[][] map) {
        for (int j = 0; j < W; j++) {
            for (int i = H - 1; i >= 0; i--) {

                if (map[i][j] == 0) {

                    int up = i - 1;

                    while (up >= 0 && map[up][j] == 0)
                        up--;

                    if (up >= 0) {
                        map[i][j] = map[up][j];
                        map[up][j] = 0;
                    }
                }
            }
        }
    }


    private static int[][] copy(int[][] map) {
        if (map == null)
            return null;

        int[][] result = new int[map.length][];

        for (int i = 0; i < map.length; i++)
            result[i] = Arrays.copyOf(map[i], map[i].length);

        return result;
    }

    private static void dfs(int i, int j, int[][] map) {

        if (map[i][j] == 0)
            return;

        int value = map[i][j];

        map[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            for (int v=1; v<value; v++) {
                int ny = i + dy[k] * v;
                int nx = j + dx[k] * v;

                if (ny >= 0 && nx >= 0 && ny < H && nx < W && map[ny][nx] > 0) {
                    dfs(ny, nx, map);
                }
            }
        }
    }
}