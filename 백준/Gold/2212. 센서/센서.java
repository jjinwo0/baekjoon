import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] sensors = new int[N];
        Integer[] gap = new Integer[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        if (N <= K){
            System.out.println(0);
            return;
        }

        for (int i=0; i<N; i++){
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);

        for (int i=0; i<N-1; i++){
            gap[i] = Math.abs(sensors[i] - sensors[i+1]);
        }
        Arrays.sort(gap, Collections.reverseOrder());

        int answer = 0;
        for (int i=K-1; i<N-1; i++){
            answer += gap[i];
        }

        System.out.println(answer);
    }
}
