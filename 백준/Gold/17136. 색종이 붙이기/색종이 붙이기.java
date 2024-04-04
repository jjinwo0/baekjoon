import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] papers = new int[]{0, 5, 5, 5, 5, 5};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[10][10];

        for (int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<10; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (answer == Integer.MAX_VALUE)
            answer = -1;

        System.out.println(answer);
    }

    private static void dfs(int y, int x, int count) {

        if (y >= 10) {
            answer = Math.min(answer, count);
            return;
        }

        if (x > 9) {
            dfs(y + 1, 0, count);
            return;
        }

        if (map[y][x] == 1){
            for (int k=5; k>0; k--){
                if (papers[k] > 0 && alreadyAttach(y, x, k)){
                    attach(y, x, k, 0);
                    papers[k] -= 1;

                    dfs(y, x + 1, count + 1);

                    attach(y, x, k, 1);
                    papers[k] += 1;
                }
            }
        } else dfs(y, x + 1, count);
    }

    private static boolean alreadyAttach(int y, int x, int size) {

        for (int i=y; i<y+size; i++){
            for (int j=x; j<x+size; j++){
                if (i < 0 || i >= 10 || j < 0 || j >= 10)
                    return false;

                if (map[i][j] != 1)
                    return false;
            }
        }

        return true;
    }

    private static void attach(int y, int x, int size, int status){

        for (int i=y; i<y+size; i++){
            for (int j=x; j<x+size; j++){
                map[i][j] = status;
            }
        }
    }
}