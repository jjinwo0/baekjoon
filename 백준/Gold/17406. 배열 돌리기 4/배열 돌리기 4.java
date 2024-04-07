import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, answer;

    static int[][] map, copyMap;

    static boolean[] visited;

    static int[][] rotates;
    static int[][] selectRotate;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        visited = new boolean[K];

        rotates = new int[K][3];
        selectRotate = new int[K][3];

        map = new int[N + 1][M + 1];
        copyMap = new int[N + 1][M + 1];

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<K; i++){

            st = new StringTokenizer(br.readLine());

            rotates[i][0] = Integer.parseInt(st.nextToken());
            rotates[i][1] = Integer.parseInt(st.nextToken());
            rotates[i][2] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        System.out.println(answer);
    }

    private static void permutation(int depth) {

        if (depth == K){
            copy();

            for (int i=0; i<K; i++){

                int r = selectRotate[i][0];
                int c = selectRotate[i][1];
                int s = selectRotate[i][2];

                rotate(r, c, s);
            }

            calc();
            return;
        }

        for (int i=0; i<K; i++){
            if (!visited[i]){
                visited[i] = true;

                selectRotate[depth][0] = rotates[i][0];
                selectRotate[depth][1] = rotates[i][1];
                selectRotate[depth][2] = rotates[i][2];
                permutation(depth + 1);

                visited[i] = false;
            }
        }
    }

    private static void calc() {

        for (int i=1; i<=N; i++){
            int sum = 0;

            for (int j=1; j<=M; j++){
                sum += copyMap[i][j];
            }

            answer = Math.min(answer, sum);
        }
    }

    private static void rotate(int r, int c, int s) {
        if (s == 0) return; // s가 0일 때는 회전할 필요가 없으므로 재귀 호출을 종료

        int[] leftUp = {r-s, c-s};
        int[] rightUp = {r-s, c+s};
        int[] rightDown = {r+s, c+s};
        int[] leftDown = {r+s, c-s};

        int[] tmp = {copyMap[rightUp[0]][rightUp[1]],
                copyMap[leftUp[0]][leftUp[1]],
                copyMap[leftDown[0]][leftDown[1]],
                copyMap[rightDown[0]][rightDown[1]]
        };

        //정사각형 윗변
        for(int j = rightUp[1]; j > leftUp[1]; j--) {
            copyMap[rightUp[0]][j] = copyMap[rightUp[0]][j-1];
        }
        copyMap[rightUp[0]][leftUp[1]+1] = tmp[1];

        //정사각형 왼쪽변
        for(int i = leftUp[0]; i < leftDown[0]; i++) {
            copyMap[i][leftUp[1]] = copyMap[i+1][leftDown[1]];
        }
        copyMap[leftDown[0]-1][leftDown[1]] = tmp[2];

        //정사각형 밑변
        for(int j = leftDown[1]; j < rightDown[1]; j++) {
            copyMap[leftDown[0]][j] = copyMap[rightDown[0]][j+1];
        }
        copyMap[rightDown[0]][rightDown[1]-1] = tmp[3];

        //정사각형 오른쪽 변
        for(int i = rightDown[0]; i > rightUp[0]; i--) {
            copyMap[i][rightDown[1]] = copyMap[i-1][rightUp[1]];
        }
        copyMap[rightUp[0]+1][rightUp[1]] = tmp[0];

        rotate(r, c, s-1);
    }

    private static void copy() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {

                copyMap[i][j] = map[i][j];
            }
        }
    }
}