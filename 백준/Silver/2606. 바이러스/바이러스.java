import java.util.Scanner;

public class Main {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[][] graph = new int[N+1][N+1];
        boolean[] check = new boolean[N+1];

        for (int i=1; i<=P; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }
        dfs(graph, 1, check, N);
        System.out.println(answer);
    }

    public static void dfs(int[][] graph, int start, boolean[] check, int N){
        check[start] = true;
        for (int i=1; i<=N; i++){
            if (graph[start][i] == 1 && check[i] == false) {
                dfs(graph, i, check, N);
                answer++;
            }
        }
    }
}
