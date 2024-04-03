import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int D, W, K;

    static int[][] map;

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            sb.append("#").append(tc).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[D][W];
            answer = Integer.MAX_VALUE;

            for (int i=0; i<D; i++){
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            inputMedicine(0, 0);

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void inputMedicine(int depth, int count) {

        if (checkMap()){
            answer = Math.min(count, answer);
        }

        if (count >= answer || depth == D) // 'count > answer'에서 'count >= answer'로 변경
            return;

        int[] copyMap = new int[W];
        // 현재 깊이의 상태를 저장
        for (int i = 0; i < W; i++) {
            copyMap[i] = map[depth][i];
        }

        // 현재 깊이에서 아무 약품도 투입하지 않는 경우
        inputMedicine(depth + 1, count);

        // 현재 깊이에서 A 약품 투입
        for (int i = 0; i < W; i++) {
            map[depth][i] = 0;
        }
        inputMedicine(depth + 1, count + 1);

        // 현재 깊이에서 B 약품 투입
        for (int i = 0; i < W; i++) {
            map[depth][i] = 1;
        }
        inputMedicine(depth + 1, count + 1);

        // 원상복구
        for (int i = 0; i < W; i++) {
            map[depth][i] = copyMap[i];
        }
    }

    private static boolean checkMap() {

        for (int j=0; j<W; j++){

            int count = 1;
            boolean flag = false;

            for (int i=1; i<D; i++){
                if (map[i][j] == map[i-1][j])
                    count++;

                else count = 1;

                if (count == K) {
                    flag = true;
                    break;
                }
            }

            if (!flag)
                return false;
        }

        return true;
    }
}