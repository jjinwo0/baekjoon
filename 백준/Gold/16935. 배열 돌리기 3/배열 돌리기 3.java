import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<R; i++){
            rotate(Integer.parseInt(st.nextToken()));
        }

        for (int i=0; i<map.length; i++){
            for (int j=0; j<map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int R) {

        if (R == 1){

            int[] temp = new int[M];

            for (int i = 0; i < N / 2; i++) {
                temp = map[i];
                map[i] = map[N - i - 1];
                map[N - i - 1] = temp;
            }
        }

        if (R == 2){

            for (int i = 0; i < N; i++) {
                int temp = 0;
                for (int j = 0; j < M / 2; j++) {

                    temp = map[i][j];
                    map[i][j] = map[i][M - j - 1];
                    map[i][M - j - 1] = temp;
                }
            }
        }

        if (R == 3){

            int[][] temp = new int[M][N];

            for (int r=0; r<R; r++){
                for (int i=0; i<N; i++){
                    for (int j=0; j<M; j++){

                        temp[j][N-1-i] = map[i][j];
                    }
                }
            }

            // map   ->  temp
            // N * M -> M * N

            // temp => map
            // M * N => M *N

            int tmp = N;
            N = M;
            M = tmp;

            map = temp;
        }

        if (R == 4){

            int[][] temp = new int[M][N];

            for (int r=0; r<R; r++){
                for (int i=0; i<N; i++){
                    for (int j=0; j<M; j++){
                        temp[j][i] = map[i][M-1-j];
                    }
                }
            }

            int tmp = N;
            N = M;
            M = tmp;

            map = temp;
        }

        if (R == 5){

            int[][] temp = new int[N][M];

            for (int r=0; r<R; r++){
                for (int i=0; i<N/2; i++){
                    for (int j=0; j<M/2; j++){
                        temp[i][j+(M/2)] = map[i][j];
                        temp[i+(N/2)][j+(M/2)] = map[i][j+(M/2)];
                        temp[i+(N/2)][j] = map[i+(N/2)][j+(M/2)];
                        temp[i][j] = map[i+(N/2)][j];

                    }
                }
            }

            map = temp;
        }

        if (R == 6){

            int[][] temp = new int[N][M];

            for (int r=0; r<R; r++){
                for (int i=0; i<N/2; i++){
                    for (int j=0; j<M/2; j++){
                        temp[i+(N/2)][j] = map[i][j];
                        temp[i][j] = map[i][j+(M/2)];
                        temp[i][j+(M/2)] = map[i+(N/2)][j+(M/2)];
                        temp[i+(N/2)][j+(M/2)] = map[i+(N/2)][j];

                    }
                }
            }
            map = temp;
        }
    }
}