import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] check;
    static int N, count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        count = 0;

        graph = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());

            // 노드의 각 번호 입력
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            // 노드 간선 연결
            graph[X].add(Y);
            graph[Y].add(X);
        }

        game(1, 0, 0);

        // 짝수면 진다!
        if (count % 2 == 0)
            System.out.println("No");
        else System.out.println("Yes");
    }

    private static void game(int x, int parent, int depth) {

        // 자식 노드의 깊이를 확인
        // 현재 노드의 size가 1이고, 연결된 값이 parent node와 같다면 단일노드
        if (graph[x].size() == 1 && graph[x].get(0) == parent){
            count+=depth;
            return;
        }

        // 자식 노드 확인 순회
        for (int child : graph[x]){

            // 자식 노드로 recursion
            if (child != parent)
                game(child, x, depth + 1);
        }
    }
}
