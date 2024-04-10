import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N];

        for (int i=0; i<N; i++)
            parents[i] = i;

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if (find(node1) == find(node2)){
                System.out.println(i + 1);
                return;
            } else
                union(node1, node2);
        }

        System.out.println(0);
    }

    private static int find(int x) {

        if (x == parents[x])
            return x;

        return parents[x] = find(parents[x]);
    }

    private static void union(int node1, int node2) {

        int x = find(node1);
        int y = find(node2);

        if (x < y)
            parents[y] = x;

        else parents[x] = y;
    }
}