import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] board = new String[N][N];

        for (int i=0; i<N; i++){
            board[i] = br.readLine().split("");
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){

                if (!board[i][j].equals(".")){
                    for (int k=0; k<4; k++){
                        int count = 1;

                        for (int n=1; n<3; n++) {
                            int nY = i + n * dy[k];
                            int nX = j + n * dx[k];

                            if (nY >= 0 && nX >= 0 && nY < N && nX < N && (board[i][j].equals(board[nY][nX])))
                                count++;
                        }

                        if (count == 3){
                            System.out.println(board[i][j]);
                            return ;
                        }
                    }
                }
            }
        }

        System.out.println("ongoing");
    }
}
