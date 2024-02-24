import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Tomato {
        int y;
        int x;
        int day;

        public Tomato(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }

    static int[][] map;

    static int N, M, answer;

    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        answer = 0;

        map = new int[N][M];
        ArrayList<Tomato> checkTomato = new ArrayList<>();

        for (int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1)
                    checkTomato.add(new Tomato(i, j, 0));
            }
        }

        bfs(checkTomato);

        System.out.println(answer);
    }

    private static void bfs(ArrayList<Tomato> checkTomato) {

        Queue<Tomato> queue = new LinkedList<>();

        int day = 0;

        for (Tomato t : checkTomato)
            queue.add(t);

        while(!queue.isEmpty()){

            Tomato tomato = queue.poll();
            day = tomato.day;

            for (int i=0; i<4; i++){
                int nY = tomato.y + dY[i];
                int nX = tomato.x + dX[i];

                if (nY >= 0 && nX >= 0 && nY < N && nX < M && map[nY][nX] == 0){
                    map[nY][nX] = 1;
                    queue.add(new Tomato(nY, nX, day+1));
                }
            }
        }

        if (checkMap())
            answer = day;
        else answer = -1;
    }

    private static boolean checkMap() {

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (map[i][j] == 0)
                    return false;
            }
        }

        return true;
    }
}