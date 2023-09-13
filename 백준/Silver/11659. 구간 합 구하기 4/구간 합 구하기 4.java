import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int idx=0;

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){

            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        int[] preSum = new int[N];
        preSum[0] = arr[0];

        for (int i=1; i<arr.length; i++)
            preSum[i] = preSum[i-1] + arr[i];

        for (int n=0; n<M; n++){

            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            System.out.println(preSum[j] - preSum[i] + arr[i]);
        }

    }
}
