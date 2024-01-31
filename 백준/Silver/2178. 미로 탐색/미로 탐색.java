import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static int[][] map;

    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0; i<N; i++){
            String[] temp = br.readLine().split("");

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        bfs(0, 0);

        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int y, int x) {

        int[] temp = {y, x};
        Queue<int[]> queue = new LinkedList<>();

        queue.add(temp);

        while(!queue.isEmpty()){

            int[] now = queue.poll();

            for (int i=0; i<4; i++) {

                int nY = now[0] + dY[i];
                int nX = now[1] + dX[i];

                if (nY < N && nY >= 0 && nX < M && nX >= 0 && map[nY][nX] == 1) {
                    queue.add(new int[]{nY, nX});
                    map[nY][nX] = map[now[0]][now[1]]+1;
                }
            }
        }
    }
}
