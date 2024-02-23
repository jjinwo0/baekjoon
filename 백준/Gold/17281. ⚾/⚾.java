import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer;
    static int[][] hitter;
    static int[] score;
    static boolean[] isSelected;
    static int[] lineUp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        hitter = new int[N][10];
        score = new int[N];
        answer = 0;

        StringTokenizer st;
        for (int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine());

            for (int j=1; j<hitter[i].length; j++){

                hitter[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isSelected = new boolean[10];
        lineUp = new int[10];

        lineUp[4] = 1;
        isSelected[4] = true;

        startLineUp(2);

        System.out.println(answer);
    }

    private static void startLineUp(int start) {

        if (start == 10){

            int sum = playball();

            answer = Math.max(answer, sum);
        }

        for (int i=1; i<=9; i++){
            if (!isSelected[i]){
                isSelected[i] = true;

                lineUp[i] = start;
                startLineUp(start + 1);

                isSelected[i] = false;
            }
        }
    }

    private static int playball() {

        int now = 1;
        int sum = 0;

        for (int i=0; i<N; i++) {

            int outCount = 0;
            int tempScore = 0;
            boolean[] base = new boolean[4];

            while (true) {

                if (now > 9)
                    now = 1;

                if (outCount == 3)
                    break;

                int hit = hitter[i][lineUp[now]];

                // out
                if (hit == 0) {
                    // 아웃카운트 추가
                    outCount++;

                    // 다음타자로 넘어감
                    now++;
                    continue;
                }

                // 안타
                if (hit == 1) {

                    // 3루에 주자가 있었다면,
                    if (base[3]) {
                        base[3] = false;
                        tempScore += 1;
                    }

                    // 2루에 주자가 있었다면,
                    if (base[2]) {
                        base[2] = false;
                        base[3] = true;
                    }

                    // 1루에 주자가 있었다면,
                    if (base[1]) {
                        base[2] = true;
                    }

                    // 1루에는 반드시 주자가 생김
                    base[1] = true;

                    // 다음타자로 넘어감
                    now++;
                    continue;
                }

                // 2루타
                if (hit == 2) {

                    if (base[3]) {
                        base[3] = false;
                        tempScore += 1;
                    }

                    if (base[2]) {
                        base[2] = false;
                        tempScore += 1;
                    }

                    if (base[1]) {
                        base[3] = true;
                        base[1] = false;
                    }

                    base[2] = true;
                    now++;
                    continue;
                }

                // 3루타
                if (hit == 3) {

                    if (base[3]) {
                        base[3] = false;
                        tempScore += 1;
                    }

                    if (base[2]) {
                        base[2] = false;
                        tempScore += 1;
                    }

                    if (base[1]) {
                        base[1] = false;
                        tempScore += 1;
                    }

                    base[3] = true;
                    now++;
                    continue;
                }

                // 홈런
                if (hit == 4) {

                    for (int k = 0; k < base.length; k++) {
                        if (base[k]) {
                            base[k] = false;
                            tempScore += 1;
                        }
                    }
                    tempScore += 1;
                    now++;
                }
            }
            sum += tempScore;
        }
        return sum;
    }
}