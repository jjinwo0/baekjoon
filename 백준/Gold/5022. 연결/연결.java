import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int y;
        int x;
        int time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int N, M, min;

    static Node[][] map;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;

        Node[] arrA = new Node[2];
        Node[] arrB = new Node[2];

        for (int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrA[i] = new Node(y, x, 0);
        }

        for (int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrB[i] = new Node(y, x, 0);
        }

        int answer1 = bfs(arrA[0], arrA[1], arrB[0], arrB[1]);
        int answer2 = bfs(arrB[0], arrB[1], arrA[0], arrA[1]);

        if (answer1 == Integer.MAX_VALUE && answer2 == Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
            return;
        }

        System.out.println(Math.min(answer1, answer2));
    }

    private static int bfs(Node nodeA1, Node nodeA2, Node nodeB1, Node nodeB2) {

        int first = 0;
        int second = 0;

        map = new Node[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        Queue<Node> queue = new LinkedList<>();

        queue.offer(nodeA1);

        visited[nodeA1.y][nodeA1.x] = true;
        visited[nodeB1.y][nodeB1.x] = true;
        visited[nodeB2.y][nodeB2.x] = true;

        while(!queue.isEmpty()){

            Node node = queue.poll();

            if (node.y == nodeA2.y && node.x == nodeA2.x){
                first = node.time;
                break;
            }

            for (int i=0; i<4; i++) {

                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                int time = node.time + 1;

                if (ny >= 0 && ny <= N && nx >= 0 && nx <= M && !visited[ny][nx]){
                    queue.offer(new Node(ny, nx, time));
                    visited[ny][nx] = true;
                    map[ny][nx] = node;
                }
            }
        }

        if (first == 0) return Integer.MAX_VALUE;

        visited = new boolean[N + 1][M + 1];

        Node now = nodeA2;

        while(true) {
            visited[now.y][now.x] = true;

            if (now.y == nodeA1.y && now.x == nodeA1.x) break;

            now = map[now.y][now.x];
        }

        queue = new LinkedList<>();
        queue.offer(nodeB1);
        visited[nodeB1.y][nodeB1.x] = true;

        while(!queue.isEmpty()){

            Node nowB = queue.poll();

            if (nowB.y == nodeB2.y && nowB.x == nodeB2.x) {
                second = nowB.time;
                break;
            }

            for (int i=0; i<4; i++) {

                int ny = nowB.y + dy[i];
                int nx = nowB.x + dx[i];
                int time = nowB.time + 1;

                if (ny >= 0 && ny <= N && nx >= 0 && nx <= M && !visited[ny][nx]){
                    queue.offer(new Node(ny, nx, time));
                    visited[ny][nx] = true;
                    map[ny][nx] = nowB;
                }
            }
        }

        if (second == 0)
            return Integer.MAX_VALUE;

        return first + second;
    }
}