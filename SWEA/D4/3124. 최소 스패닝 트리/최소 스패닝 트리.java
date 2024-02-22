import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int value;

        public Edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {

            return Integer.compare(this.value, o.value);
        }
    }

    static int V, E;
    static long weight;

    static BufferedReader br;
    static int[] parents;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case<=T; test_case++){

            sb.append("#").append(test_case).append(" ");

            make();

            weight = 0;

            Arrays.sort(edges);

            for (Edge edge : edges) {
                int a = edge.a;
                int b = edge.b;

                if (find(a) != find(b)){
                    union(a, b);
                    weight += edge.value;
                }
            }

            sb.append(weight).append("\n");
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return;

        if (rootA > rootB)
            parents[rootA] = rootB;

        else parents[rootB] = rootA;
    }

    private static int find(int node) {

        if (node == parents[node])
            return node;

        return parents[node] = find(parents[node]);
    }

    private static void make() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new Edge[E];
        parents = new int[V+1];

        for (int i=1; i<=V; i++){
            parents[i] = i;
        }

        for (int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, value);
        }
    }
}
