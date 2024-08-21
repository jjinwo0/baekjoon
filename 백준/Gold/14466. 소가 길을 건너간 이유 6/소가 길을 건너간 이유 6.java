import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, K, R;
    static int[][] map;
    static Node[] cows;
    static ArrayList<Integer>[] coupled;
    static ArrayList<Node>[][] bridge;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        cows = new Node[K + 1];
        bridge = new ArrayList[N + 1][N + 1];
        coupled = new ArrayList[K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bridge[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= K; i++) {
            coupled[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            bridge[r1][c1].add(new Node(r2, c2));
            bridge[r2][c2].add(new Node(r1, c1));
        }

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = i;
            cows[i] = new Node(r, c);
        }

        int answer = 0;

        for (int i = 1; i <= K; i++) {
            boolean[][] checked = bfs(cows[i]);

            for (int j = i + 1; j <= K; j++) {
                if (!checked[map[cows[i].y][cows[i].x]][map[cows[j].y][cows[j].x]]) {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }

    private static boolean[][] bfs(Node cow) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][N + 1];
        boolean[][] check = new boolean[K + 1][K + 1];

        queue.offer(cow);
        visited[cow.y][cow.x] = true;
        check[map[cow.y][cow.x]][map[cow.y][cow.x]] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (ny > 0 && nx > 0 && ny <= N && nx <= N && !visited[ny][nx]) {
                    boolean canMove = true;

                    for (Node b : bridge[current.y][current.x]) {
                        if (b.y == ny && b.x == nx) {
                            canMove = false;
                            break;
                        }
                    }

                    if (canMove) {
                        visited[ny][nx] = true;
                        queue.offer(new Node(ny, nx));
                        if (map[ny][nx] > 0) {
                            check[map[cow.y][cow.x]][map[ny][nx]] = true;
                        }
                    }
                }
            }
        }

        return check;
    }
}