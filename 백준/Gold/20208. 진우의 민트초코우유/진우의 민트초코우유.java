import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Location {

        int y;
        int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, H, answer;

    static int[][] map;

    static boolean[] visited;

    static Location home;

    static ArrayList<Location> mintList;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        mintList = new ArrayList<>();

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1)
                    home = new Location(i, j);

                if (map[i][j] == 2)
                    mintList.add(new Location(i, j));
            }
        }

        visited = new boolean[mintList.size()];

        for (int i=0; i<mintList.size(); i++){

            Location now = mintList.get(i);

            int dist = Math.abs(now.y - home.y) + Math.abs(now.x - home.x);

            if (dist <= M)
                move(now, i, M - dist + H, 1);
        }

        System.out.println(answer);
    }

    private static void move(Location now, int index, int health, int count) {

        visited[index] = true;

        for (int i=0; i<mintList.size(); i++) {

            if (!visited[i]){

                Location next = mintList.get(i);

                int dist = Math.abs(next.y - now.y) + Math.abs(next.x - now.x);

                if (dist <= health)
                    move(next, i, health - dist + H, count + 1);
            }
        }

        int homeDist = Math.abs(now.y - home.y) + Math.abs(now.x - home.x);

        if (homeDist <= health)
            answer = Math.max(answer, count);

        visited[index] = false;
    }
}