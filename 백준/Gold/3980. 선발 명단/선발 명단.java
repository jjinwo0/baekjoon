import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int max;
    static int[][] s;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            int C = Integer.parseInt(br.readLine());
            s = new int[11][11];
            visit = new boolean[11];
            while (C-- > 0) {
                for (int i = 0; i < 11; ++i) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < 11; ++j) {
                        s[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                dfs(0, 0);
                bw.write(max + "\n");
                Arrays.fill(visit, false);
                max = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int y, int v) {
        if (y == 11) {
            max = Math.max(max, v);
            return;
        }

        for (int i = 0; i < 11; ++i) {
            if (visit[i] || s[y][i] == 0) continue;
            visit[i] = true;
            dfs(y + 1, v + s[y][i]);
            visit[i] = false;
        }
    }
}