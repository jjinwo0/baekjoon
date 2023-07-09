import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        int[][] graph = new int[N+1][N+1];
        boolean[] check = new boolean[N+1];
        for (int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = graph[b][a] = 1;
        }

        dfs(graph, V, check, N);
        System.out.println();
        for (int i=0; i< check.length; i++){
            check[i] = false;
        }
        bfs(graph, V, check, N);
    }

    public static void dfs(int[][] graph, int start, boolean[] check, int N){
        check[start] = true;
        System.out.print(start + " ");
        for (int i=1; i<=N; i++){
            if (graph[start][i]==1 && check[i]==false)
                dfs(graph, i, check, N);
        }
    }

    public static void bfs(int[][] graph, int start, boolean[] check, int N){
        Queue<Integer> queue = new LinkedList<>();
        int temp;
        check[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            temp = queue.poll();
            System.out.print(temp + " ");
            for (int i=1; i<=N; i++){
                if (graph[temp][i] == 1 && check[i] == false){
                    check[i] = true;
                    queue.add(i);
                }
            }

        }
    }
}
