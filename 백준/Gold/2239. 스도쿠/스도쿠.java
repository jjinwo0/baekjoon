import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    
    static int[][] board;
    
    static ArrayList<int[]> zeroList;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        zeroList = new ArrayList<>();

        for (int i=0; i<9; i++){

            char[] chars = br.readLine().toCharArray();

            for (int j=0; j<9; j++){
                board[i][j] = chars[j] - '0';

                if (board[i][j] == 0)
                    zeroList.add(new int[]{i, j});
            }
        }
        
        sudoku(0);
    }

    private static void sudoku(int index) {

        if (index == zeroList.size()) {

            for (int i=0; i<9; i++){
                for (int j=0; j<9; j++){
                    System.out.print(board[i][j]);
                }

                System.out.println();
            }
            System.exit(0);
        }

        int y = zeroList.get(index)[0];
        int x = zeroList.get(index)[1];

        boolean[] check = new boolean[10];

        for (int i=0; i<9; i++){
            if(board[i][x] != 0)
                check[board[i][x]] = true;
        }

        for (int j=0; j<9; j++){
            if (board[y][j] != 0)
                check[board[y][j]] = true;
        }

        int squareY = (y/3) * 3;
        int squareX = (x/3) * 3;

        for (int i=squareY; i<squareY+3; i++){
            for (int j=squareX; j<squareX+3; j++){
                if (board[i][j] != 0)
                    check[board[i][j]] = true;
            }
        }

        for(int i=1; i<10; i++){
            if(!check[i]){
                board[y][x] = i;
                sudoku(index + 1);
                board[y][x] = 0;
            }
        }
    }
}