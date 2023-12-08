import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static ArrayList<Integer>[] list;
    static boolean[] check;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N];
        check = new boolean[N];

        for (int i=0; i<N; i++){
            list[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        for (int i=0; i<N; i++){
            if (answer == 0)
                dfs(i, 1);
        }

        System.out.println(answer);
    }

    private static void dfs(int start, int depth) {

        if (depth == 5) {
            answer = 1;
            return;
        }

        check[start] = true;

        for (int i : list[start]){
            int next = i;

            if (!check[next])
                dfs(next, depth+1);
        }

        check[start] = false;
    }
}
