import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;

    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int n=0; n<Math.min(N, M)/2; n++){

            ArrayDeque<Integer> queue = new ArrayDeque<>();

            // 배열의 요소를 큐에 넣습니다.
            for (int i = n; i < M - n; i++) {
                queue.offer(map[n][i]);
            }
            for (int i = n + 1; i < N - n; i++) {
                queue.offer(map[i][M - 1 - n]);
            }
            for (int i = M - 2 - n; i >= n; i--) {
                queue.offer(map[N - 1 - n][i]);
            }
            for (int i = N - 2 - n; i > n; i--) {
                queue.offer(map[i][n]);
            }

// R번 회전시킵니다.
            for (int i = 0; i < R; i++) {
                queue.add(queue.poll());
            }

// 큐에서 요소를 빼고 배열에 다시 넣습니다.
            for (int i = n; i < M - n; i++) {
                map[n][i] = queue.poll();
            }
            for (int i = n + 1; i < N - n; i++) {
                map[i][M - 1 - n] = queue.poll();
            }
            for (int i = M - 2 - n; i >= n; i--) {
                map[N - 1 - n][i] = queue.poll();
            }
            for (int i = N - 2 - n; i > n; i--) {
                map[i][n] = queue.poll();
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}