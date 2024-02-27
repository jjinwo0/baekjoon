import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;

    static int R, C;

    static boolean[][] visited;

    static int[] dX = {1, 0, -1, 0};

    static int[] dY = {0, 1, 0, -1};

    static int[][] swan = new int[2][2];

    static Queue<int[]> location = new LinkedList<>();

    static Queue<int[]> melt = new LinkedList();

    static int day;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        day = 0;

        map = new char[R][C];
        visited = new boolean[R][C];

        int index = 0;

        for(int i=0; i<R; i++) {

            map[i] = br.readLine().toCharArray();

            for(int j=0; j<C; j++) {
                if(map[i][j] == 'L') {

                    swan[index][0] = i; swan[index][1] = j;
                    index++;
                }

                if (map[i][j] == '.' || map[i][j] == 'L') // 수정된 부분
                    melt.offer(new int[]{i, j});
            }
        }

        location.offer(new int[]{swan[0][0], swan[0][1]});
        visited[swan[0][0]][swan[0][1]] = true;

        while(!bfs()){

            nextDay();

            day++;
        }

        System.out.println(day);
    }


    private static boolean bfs() {

        Queue<int[]> queue = new LinkedList<>();

        while(!location.isEmpty()){

            int[] poll = location.poll();

            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++){
                int nY = y + dY[i];
                int nX = x + dX[i];

                if (nY >= 0 && nX >= 0 && nY < R && nX < C && !visited[nY][nX]){

                    visited[nY][nX] = true;

                    if (nY == swan[1][0] && nX == swan[1][1])
                        return true;

                    if (map[nY][nX] == 'X')
                        queue.add(new int[]{nY, nX});

                    else location.add(new int[]{nY, nX});
                }
            }
        }

        location = queue;
        return false;
    }

    // 얼음을 녹이는 동작
    private static void nextDay() {

        int size = melt.size();

        for (int i=0; i<size; i++){

            int[] poll = melt.poll();

            int y = poll[0];
            int x = poll[1];

            for (int k=0; k<4; k++){
                int nY = y + dY[k];
                int nX = x + dX[k];

                // 물에 인접한 얼음이라면,
                if (nY >= 0 && nX >= 0 && nY < R && nX < C && map[nY][nX] == 'X'){
                    map[nY][nX] = '.';
                    melt.add(new int[]{nY, nX});
                }
            }
        }
    }
}