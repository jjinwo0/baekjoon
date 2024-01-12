import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 다시보기
public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int M, N, K, count;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int n=y1; n<y2; n++){
                for (int m=x1; m<x2; m++){
                    map[n][m] = 1;
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for (int n=0; n<N; n++){
            for (int m=0; m<M; m++){
                if (map[n][m] == 0){
                    count = 0;
                    dfs(n, m);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        for (int n=0; n<answer.size(); n++)
            bw.write(answer.get(n) + " ");

        System.out.println(answer.size());

        bw.flush();
        bw.close();
    }

    private static void dfs(int y, int x) {

        map[y][x] = 1;
        count++;

        for (int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N){
                if (map[ny][nx] == 0)
                    dfs(ny, nx);
            }
        }
    }
}
