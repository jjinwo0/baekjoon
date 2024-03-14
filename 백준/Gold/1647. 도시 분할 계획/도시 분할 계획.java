import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int N, M, max;
    static int[] parents;
    static long answer;
    static PriorityQueue<Node> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];

        for (int i=1; i<=N; i++){
            parents[i] = i;
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            queue.add(new Node(start, end, weight));
        }
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (!isParent(poll.start, poll.end)) {
                union(poll.start, poll.end);
                answer += poll.weight;
                max = poll.weight;
            }
        }

        System.out.println(answer - max);
    }
    public static int find(int x) {
        if (x == parents[x]) {
            return x;
        } else {
            return parents[x] = find(parents[x]);
        }
    }

    public static boolean isParent(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp != yp) {
            return false;
        } else {
            return true;
        }
    }

    public static void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        parents[yp] = xp;
    }
}