import java.util.*;

public class Solution {

    static int[][] arr;
    static int max;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case=1; test_case<=T; test_case++){

            N = sc.nextInt();
            M = sc.nextInt();
            max = 0;

            arr = new int[N][N];

            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i=0; i<N; i++){
                for (int j=0; j<N; j++){
                    int crossScore = checkCross(i, j);
                    int xScore = checkX(i, j);
                    max = Math.max(max, Math.max(crossScore, xScore));
                }
            }

            System.out.println("#"+test_case+" "+max);
        }
    }

    private static int checkCross(int y, int x) {
        int score = 0;

        score += arr[y][x];

        for (int i=1; i<M; i++){
            if (y-i >= 0){
                score += arr[y-i][x];
            }

            if (x-i >= 0){
                score += arr[y][x-i];
            }

            if (y + i < N){
                score += arr[y+i][x];
            }

            if (x + i < N){
                score += arr[y][x+i];
            }
        }

        return score;
    }

    private static int checkX(int y, int x) {
        int score = 0;

        score += arr[y][x];

        for (int i=1; i<M; i++){

            if (y-i >= 0 && x-i >= 0)
                score += arr[y-i][x-i];

            if (y+i < N && x-i >= 0)
                score += arr[y+i][x-i];

            if (y-i >= 0 && x+i < N)
                score += arr[y-i][x+i];

            if (y+i < N && x+i < N)
                score += arr[y+i][x+i];
        }

        return score;
    }
}
