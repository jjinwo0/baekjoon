import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[][] arr = new String[20][3];
        double total = 0;
        double grade = 0;

        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                arr[i][j] = sc.next();
            }
            if (arr[i][2].equals("P")){
                continue;
            }else {
                total += Double.parseDouble(arr[i][1]);
                if (arr[i][2].equals("A+"))
                    grade += Double.parseDouble(arr[i][1]) * 4.5;
                else if (arr[i][2].equals("A0"))
                    grade += Double.parseDouble(arr[i][1]) * 4.0;
                else if (arr[i][2].equals("B+"))
                    grade += Double.parseDouble(arr[i][1]) * 3.5;
                else if (arr[i][2].equals("B0"))
                    grade += Double.parseDouble(arr[i][1]) * 3.0;
                else if (arr[i][2].equals("C+"))
                    grade += Double.parseDouble(arr[i][1]) * 2.5;
                else if (arr[i][2].equals("C0"))
                    grade += Double.parseDouble(arr[i][1]) * 2.0;
                else if (arr[i][2].equals("D+"))
                    grade += Double.parseDouble(arr[i][1]) * 1.5;
                else if (arr[i][2].equals("D0"))
                    grade += Double.parseDouble(arr[i][1]) * 1.0;
                else
                    grade += 0;
            }
        }

        System.out.printf("%.6f", grade/total);
    }
}
