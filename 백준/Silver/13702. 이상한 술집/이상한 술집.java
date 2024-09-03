import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long max = Long.MIN_VALUE;

        for (int i=0; i<N; i++) {

            arr[i] = Long.parseLong(br.readLine());

            max = Math.max(max, arr[i]);
        }

        long low = 1;
        long high = max;

        while(low <= high) {

            long mid = (low + high)/2;
            int count = 0;

            for (int i=0; i<N; i++) {
                count += arr[i] / mid;
            }

            if (count >= K)
                low = mid + 1;

            else high = mid - 1;
        }

        System.out.println(high);
    }
}