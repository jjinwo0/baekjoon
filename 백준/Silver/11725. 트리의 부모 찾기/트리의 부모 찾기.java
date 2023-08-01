import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    static StringTokenizer st;
    static ArrayList<Integer> graph[];
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        graph = new ArrayList[N+1];
        check = new boolean[N+1];

        for (int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        for (int i=2; i< parent.length; i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int index){
        check[index] = true;
        for (int i : graph[index]){
            if(!check[i]){
                parent[i] = index;
                dfs(i);
            }
        }
    }
}
