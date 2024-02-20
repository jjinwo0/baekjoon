import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited;
        int[][] next;

        int cheese = 0;

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1)
                    cheese++;
            }
        }

        boolean isTrue = true;

        if (cheese == 0)
            isTrue = false;

        int time = 0;

        while(isTrue){
            visited = new boolean[N][M];
            next = new int[N][M];

            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[]{0, 0});

            visited[0][0] = true;

            while(!queue.isEmpty()){

                int[] poll = queue.poll();

                int y = poll[0];
                int x = poll[1];

                for (int i=0; i<4; i++){

                    int nY = y + dY[i];
                    int nX = x + dX[i];

                    if (nY >= 0 && nX >= 0 && nY < N && nX < M && !visited[nY][nX]) {

                        if (map[nY][nX] == 1) {
                            visited[nY][nX] = true;
                            next[nY][nX] = 1;
                        }

                        if (map[nY][nX] == 0){
                            visited[nY][nX] = true;
                            queue.add(new int[]{nY, nX});
                        }
                    }
                }
            }

            int sum = 0;

            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){

                    map[i][j] -= next[i][j];

                    if (map[i][j] == 1)
                        sum++;
                }
            }

            time++;

            if (sum == 0)
                isTrue = false;

            else cheese = sum;
        }

        sb.append(time).append("\n").append(cheese);

        System.out.println(sb);
    }
}