import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static int[] arr, temp;

    static boolean[] visited;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        temp = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursion(0, 0);

        System.out.println(sb.toString());
    }

    private static void recursion(int depth, int start) {

        if (depth == M){
            for (int i=0; i<temp.length; i++){
                sb.append(temp[i] + " ");
            }
            sb.append("\n");
            return ;
        }

        for (int i=start; i<N; i++){
            visited[i] = true;
            temp[depth] = arr[i];
            recursion(depth+1, i+1);
            visited[i] = false;
        }
    }
}
