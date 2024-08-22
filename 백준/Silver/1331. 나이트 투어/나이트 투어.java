import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] map = new boolean[6][6];

        int[] firstMove = new int[2];
        int[] lastMove = new int[2];

        for (int i=0; i<36; i++){
            String location = br.readLine();

            char c = location.charAt(0);
            int r = location.charAt(1) - '0';

            int col = c - 'A';
            int row = r - 1;

            if (i == 0) {
                firstMove[0] = col;
                firstMove[1] = row;
            } else {
                int colDiff = Math.abs(lastMove[0] - col);
                int rowDiff = Math.abs(lastMove[1] - row);
                if (!(colDiff == 2 && rowDiff == 1) && !(colDiff == 1 && rowDiff == 2)) {
                    System.out.println("Invalid");
                    return;
                }
            }

            if (map[col][row]) {
                System.out.println("Invalid");
                return;
            }

            map[col][row] = true;
            lastMove[0] = col;
            lastMove[1] = row;
        }

        int colDiff = Math.abs(firstMove[0] - lastMove[0]);
        int rowDiff = Math.abs(firstMove[1] - lastMove[1]);

        if ((colDiff == 2 && rowDiff == 1) || (colDiff == 1 && rowDiff == 2)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}