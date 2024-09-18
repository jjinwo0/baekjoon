import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int N,M,R;
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> graph =new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        R = Integer.parseInt(st.nextToken());  //시작 점

        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(List<Integer> l : graph){
            Collections.sort(l,Collections.reverseOrder());
        }

        BFS(R);


    }

    private static void BFS(int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        visited[r] = true;
        int cnt = 0;
        int count[] = new int[N+1];
        while (!queue.isEmpty()){
            int now = queue.poll();
            count[now] = ++cnt;
            for(int i =0;i<graph.get(now).size();i++){


                int nextVertex = graph.get(now).get(i);
                if(!visited[nextVertex]){
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
        for(int i=1;i<=N;i++) System.out.println(count[i]);


    }
}