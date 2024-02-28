import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static int[][] map;

    static int N, answer, coreCount;

    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};

    static ArrayList<int[]> coreList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case=1; test_case<=T; test_case++){

            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            coreList = new ArrayList<>();
            answer = Integer.MAX_VALUE;
            coreCount = Integer.MIN_VALUE;

            for (int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (i != 0 && j != 0 && i != N - 1 && j != N - 1 && map[i][j] == 1)
                        coreList.add(new int[]{i, j});
                }
            }

            connect(0, 0, 0);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void connect(int index, int core, int count) {

        if (index == coreList.size()){

            if (core > coreCount){
                coreCount = core;
                answer = count;
            }

            if (core == coreCount)
                answer = Math.min(count, answer);

            return;
        }

        int[] tempCore = coreList.get(index);

        int y = tempCore[0];
        int x = tempCore[1];

        for (int i=0; i<4; i++){

            int cnt = 0;
            int ny = y; int nx = x;

            while(true) {

                ny += dy[i];
                nx += dx[i];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N)
                    break;

                if (map[ny][nx] == 1) {
                    cnt = 0;
                    break;
                }

                cnt++;
            }

            if (cnt == 0)
                connect(index+1, core, count);

            else {
                int tempX = x;
                int tempY = y;

                for (int n = 0; n < cnt; n++) {
                    tempY += dy[i];
                    tempX += dx[i];
                    map[tempY][tempX] = 1;
                }

                connect(index+1, core+1, count+cnt);

                tempX = x;
                tempY = y;

                for (int n = 0; n < cnt; n++) {
                    tempY += dy[i];
                    tempX += dx[i];
                    map[tempY][tempX] = 0;
                }
            }
        }
    }
}