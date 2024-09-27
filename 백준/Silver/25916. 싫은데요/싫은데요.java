import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        while (right < n) {
            if (count +a[right] <= m) {
                count += a[right];
                max = Integer.max(max, count);
                right++;
            }else{
                count -= a[left];
                left++;
            }
        }

        System.out.println(max);

    }
}