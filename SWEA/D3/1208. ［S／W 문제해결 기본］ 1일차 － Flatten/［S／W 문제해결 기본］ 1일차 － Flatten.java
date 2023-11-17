import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int tc=1; tc<=T; tc++){
            int count = sc.nextInt();
            int[] arr = new int[100];

            for (int i=0; i<arr.length; i++){
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            for (int i=0; i<count; i++){
                arr[0]++;
                arr[99]--;
                Arrays.sort(arr);
            }

            System.out.println("#"+tc+" "+(arr[99]-arr[0]));
        }
    }
}
