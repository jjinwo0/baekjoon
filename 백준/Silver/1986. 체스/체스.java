import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int kx[] = {1,2,2,1,-1,-2,-2,-1};
    static int ky[] = {-2,-1,1,2,2,1,-1,-2};
    static int qx[] = {0,1,1,1,0,-1,-1,-1};
    static int qy[] = {-1,-1,0,1,1,1,0,-1};
    static int n, m;
    static boolean visit[][];
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];

        st = new StringTokenizer(br.readLine());
        int queenCount = Integer.parseInt(st.nextToken());

        for (int i=0; i<queenCount; i++){
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int knightCount = Integer.parseInt(st.nextToken());

        for (int i=0; i<knightCount; i++){
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 2;
        }

        st = new StringTokenizer(br.readLine());
        int pawnCount = Integer.parseInt(st.nextToken());

        for (int i=0; i<pawnCount; i++){
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 3;
        }

        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (map[i][j] == 1)
                    moveQueen(i, j);

                if (map[i][j] == 2)
                    moveKnight(i, j);
            }
        }

        int count = 0;

        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                if (map[i][j] == 0)
                    count++;
            }
        }

        System.out.println(count);
    }

    public static void moveQueen(int y, int x) {

        for (int i=0; i<8; i++){

            int ny = y;
            int nx = x;
            while(true) {

                ny += qy[i];
                nx += qx[i];

                if (ny > 0 && nx > 0 && ny <= n && nx <= m && (map[ny][nx] == 0 || map[ny][nx] == -1))
                    map[ny][nx] = -1;

                else break;
            }
        }
    }

    public static void moveKnight(int y, int x) {

        for (int i=0; i<8; i++){

            int ny = y + ky[i];
            int nx = x + kx[i];

            if (ny > 0 && nx > 0 && ny <= n && nx <= m && (map[ny][nx] == 0))
                map[ny][nx] = -1;
        }
    }
}