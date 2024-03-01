import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new boolean[101][101];

        int N = Integer.parseInt(br.readLine());
        answer = 0;

        for (int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            list.add(d);

            for (int i=0; i<g; i++){
                for (int j=list.size()-1; j>=0; j--){
                    list.add((list.get(j) + 1) % 4);
                }
            }

            map[y][x] = true;

            for (int i : list){
                int ny = y + dy[i];
                int nx = x + dx[i];

                map[ny][nx] = true;

                y = ny;
                x = nx;
            }
        }

        for (int i=0; i<100; i++){
            for (int j=0; j<100; j++){
                if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
                    answer++;
            }
        }

        System.out.println(answer);
    }
}