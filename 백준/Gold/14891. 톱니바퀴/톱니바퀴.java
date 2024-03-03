import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] chain;

    static int[] rotation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        chain = new char[5][8];
        rotation = new int[5];

        for (int i=1; i<=4; i++){
            chain[i] = br.readLine().toCharArray();
        }

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            setRotation(N, dir);
            doRotate();
        }

        int answer = 0;

        for (int i=1; i<=4; i++){
            if (chain[i][0] == '1')
                answer += Math.pow(2, (i-1));
        }

        System.out.println(answer);
    }

    private static void setRotation(int N, int dir) {
        int[] tempRotation = new int[5];
        tempRotation[N] = dir;

        // 왼쪽 톱니바퀴들을 확인
        for (int i = N - 1; i >= 1; i--) {
            if (chain[i][2] != chain[i + 1][6]) {
                tempRotation[i] = -tempRotation[i + 1];
            } else {
                break;
            }
        }

        // 오른쪽 톱니바퀴들을 확인
        for (int i = N + 1; i <= 4; i++) {
            if (chain[i][6] != chain[i - 1][2]) {
                tempRotation[i] = -tempRotation[i - 1];
            } else {
                break;
            }
        }

        // 최종 회전방향을 설정
        for (int i = 1; i <= 4; i++) {
            rotation[i] = tempRotation[i];
        }
    }

    private static void doRotate() {
        for (int i=1; i<=4; i++){
            if (rotation[i] == 1){
                chain[i] = clock(chain[i]);
            }

            if (rotation[i] == -1){
                chain[i] = counter(chain[i]);
            }
        }
        rotation = new int[5];
    }

    private static char[] clock(char[] chars) {
        char[] temp = new char[8];

        temp[0] = chars[7];

        for (int i=1; i<=7; i++){
            temp[i] = chars[i-1];
        }
        return temp;
    }

    private static char[] counter(char[] chars) {
        char[] temp = new char[8];

        temp[7] = chars[0];

        for (int i=1; i<8; i++){
            temp[i-1] = chars[i];
        }
        return temp;
    }
}