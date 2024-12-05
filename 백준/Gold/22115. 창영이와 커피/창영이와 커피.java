import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br;

    private static int N, K;
    private static int[] arr, memo;
    private static final int MAX = 100_101;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } 

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        memo[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = K; j >= 0; j--) {
                if (j - arr[i] >= 0 && memo[j - arr[i]] != MAX) {
                    memo[j] = Math.min(memo[j], memo[j - arr[i]] + 1);
                }
            }
        }
        
        sb.append(memo[K] == MAX ? -1 : memo[K]);
        return sb.toString();
    } 

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        memo = new int[K + 1];
        Arrays.fill(memo, MAX);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}