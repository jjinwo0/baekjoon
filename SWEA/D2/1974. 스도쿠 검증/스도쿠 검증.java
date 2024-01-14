import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case=1; test_case<=T; test_case++){
            int[][] sudoku = new int[9][9];
            boolean isValid = true;

            for (int i=0; i<9; i++){
                for (int j=0; j<9; j++){
                    sudoku[i][j] = sc.nextInt();
                }
            }

            for (int i=0; i<9; i++){
                HashSet<Integer> row = new HashSet<>();
                HashSet<Integer> col = new HashSet<>();
                HashSet<Integer> box = new HashSet<>();

                for (int j=0; j<9; j++){
                    if (!row.add(sudoku[i][j]) || !col.add(sudoku[j][i]) || !box.add(sudoku[3*(i/3) + j/3][3*(i%3) + j%3])){
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) break;
            }
            System.out.println("#"+test_case+" "+ (isValid ? 1 : 0));
        }
    }
}
