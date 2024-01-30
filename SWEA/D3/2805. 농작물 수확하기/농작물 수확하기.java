import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case=1; test_case<=T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                String input = br.readLine();

                for (int j = 0; j < N; j++) {
                    arr[i][j] = input.charAt(j) - '0';
                }
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {

                if (i <= N / 2) {
                    for (int j = Math.abs(N / 2 - i); j <= Math.abs(N / 2 + i); j++) {
                        sum += arr[i][j];
                    }
                } else {
                    for (int j = Math.abs(N / 2 - i); j <= Math.abs(N / 2 + (N - 1 - i)); j++) {
                        sum += arr[i][j];
                    }
                }
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
