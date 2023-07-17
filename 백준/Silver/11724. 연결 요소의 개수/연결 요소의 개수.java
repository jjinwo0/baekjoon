import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[] check;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N+1][N+1];
        check = new boolean[N+1];

        for (int i=1; i<=M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }

        for (int i=1; i<=N; i++){
            if (check[i] == false){
                answer++;
                dfs(i);
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int start){
        check[start] = true;

        for (int i=1; i<=N; i++){
            if (graph[start][i] == 1 && check[i] == false)
                dfs(i);
        }
    }
}
