import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int TEAM = 6;

    static int[] win = new int[TEAM];
    static int[] draw = new int[TEAM];
    static int[] lose = new int[TEAM];

    static int[][] matches = {
            {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
            {1, 2}, {1, 3}, {1, 4}, {1, 5},
            {2, 3}, {2, 4}, {2, 5},
            {3, 4}, {3, 5},
            {4, 5}
    };

    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int n=0; n<4; n++){
            st = new StringTokenizer(br.readLine());

            int matchSum = 0;
            boolean flag = true;
            for (int i=0; i<6; i++){
                win[i] = Integer.parseInt(st.nextToken());
                draw[i] = Integer.parseInt(st.nextToken());
                lose[i] = Integer.parseInt(st.nextToken());

                matchSum += win[i] + draw[i] + lose[i];

                if (win[i] + draw[i] + lose[i] != 5)
                    flag = false;
            }

            if (matchSum != 30)
                flag = false;

            result = false;

            if (flag){
                checkMatch(0);
            }

            if (result)
                sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    private static void checkMatch(int depth) {

        if (result)
            return;

        if (depth == 15){
            result = true;
            return;
        }

        int teamA = matches[depth][0];
        int teamB = matches[depth][1];

        win[teamA]--;
        lose[teamB]--;
        if (win[teamA] >= 0 && lose[teamB] >= 0)
            checkMatch(depth + 1);
        win[teamA]++;
        lose[teamB]++;

        draw[teamA]--;
        draw[teamB]--;
        if (draw[teamA] >= 0 && draw[teamB] >= 0)
            checkMatch(depth + 1);
        draw[teamA]++;
        draw[teamB]++;

        lose[teamA]--;
        win[teamB]--;
        if (lose[teamA] >= 0 && win[teamB] >= 0)
            checkMatch(depth + 1);
        lose[teamA]++;
        win[teamB]++;
    }
}
