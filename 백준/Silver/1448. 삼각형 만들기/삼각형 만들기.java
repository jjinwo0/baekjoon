import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] length = new Integer[n];

        for (int i = 0; i < n; i++) {
            length[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        
        Arrays.sort(length, Collections.reverseOrder());
        
        for (int i = 0; i < n - 2; i++) {
        
            if (length[i] < length[i + 1] + length[i + 2]) {
                max = Math.max(max, length[i] + length[i + 1] + length[i + 2]);
            }
        }
        
        if (max == 0) {
            max = -1;
        }
        System.out.println(max);
    }
}