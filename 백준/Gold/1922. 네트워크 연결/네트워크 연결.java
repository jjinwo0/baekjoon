import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{

        int to;
        int from;
        int value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node> list = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list.add(new Node(to, from, value));
        }

        Collections.sort(list);

        int answer = 0;

        for (int i=0; i<list.size(); i++) {

            Node node = list.get(i);

            int x = find(node.to);
            int y = find(node.from);

            if (x != y){

                union(node.to, node.from);
                answer += node.value;
            }
        }

        System.out.println(answer);
    }

    private static int find(int n) {

        if (parent[n] == n) return n;

        return parent[n] = find(parent[n]);
    }

    private static void union(int x, int y) {

        int dirX = find(x);
        int dirY = find(y);

        if (dirX != dirY)
            parent[dirY] = dirX;
    }
}