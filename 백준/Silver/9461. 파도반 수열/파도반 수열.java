import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){

            int n = Integer.parseInt(br.readLine());

            if (n <= 3) {
                sb.append(1).append("\n");
                continue;
            }

            long[] arr = new long[n + 1];

            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;

            for (int i = 4; i <= n; i++){
                arr[i] = arr[i-2] + arr[i-3];
            }

            sb.append(arr[n]).append("\n");
        }

        System.out.println(sb);
    }
}