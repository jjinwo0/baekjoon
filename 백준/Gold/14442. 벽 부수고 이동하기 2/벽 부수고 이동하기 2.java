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
        int count;
        int breakWall;

        public Node(int y, int x, int count, int breakWall) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.breakWall = breakWall;
        }
    }

    static int N, M, K, answer;

    static int[][] map;

    static boolean[][][] visited;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K + 1];
        answer = Integer.MAX_VALUE;

        for (int i=0; i<N; i++){
            char[] charArray = br.readLine().toCharArray();

            for (int j=0; j<M; j++) {
                map[i][j] = Character.getNumericValue(charArray[j]);
            }
        }

        bfs();

        if (answer == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    private static void bfs() {

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, 1, 0));

        visited[0][0][0] = true;

        while(!queue.isEmpty()){

            Node next = queue.poll();

            if (next.y == N - 1 && next.x == M - 1) {
                answer = Math.min(answer, next.count);
                continue;
            }

            for (int k=0; k<4; k++){

                int ny = next.y + dy[k];
                int nx = next.x + dx[k];

                if (ny >= 0 && nx >= 0 && ny < N && nx < M) {

                    if (map[ny][nx] == 1 && next.breakWall < K && !visited[ny][nx][next.breakWall + 1]){
                        visited[ny][nx][next.breakWall + 1] = true;
                        queue.offer(new Node(ny, nx, next.count + 1, next.breakWall + 1));
                        continue;
                    }

                    if (map[ny][nx] == 0 && !visited[ny][nx][next.breakWall]){
                        visited[ny][nx][next.breakWall] = true;
                        queue.offer(new Node(ny, nx, next.count + 1, next.breakWall));
                    }
                }
            }
        }
    }
}