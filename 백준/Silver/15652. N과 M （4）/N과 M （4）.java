import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static StringBuilder sb;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        rec(0);

        System.out.println(sb.toString());
    }

    private static void rec(int index) {

        if (index == M){
            for (int i=0; i<M; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1; i<=N; i++){

            if (index > 0 && arr[index-1] > i)
                continue;
            arr[index] = i;
            rec(index + 1);
        }
    }
}