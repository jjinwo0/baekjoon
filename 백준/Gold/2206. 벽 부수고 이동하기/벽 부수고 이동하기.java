import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int y;
        int x;
        int distance;
        int wall;

        public Node(int y, int x, int distance, int wall) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.wall = wall;
        }
    }

    static char[][] map;

    static int N, M, answer;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        map = new char[N][M];
        visited = new boolean[N][M][2];
        ArrayList<int[]> wall = new ArrayList<>();


        for (int i=0; i<N; i++){
            char[] arr = br.readLine().toCharArray();

            for (int j=0; j<M; j++){
                map[i][j] = arr[j];

                if (map[i][j] == '1')
                    wall.add(new int[]{i, j});
            }
        }

        bfs();

        if (answer == Integer.MAX_VALUE)
            answer = -1;

        System.out.println(answer);
    }

    private static void bfs() {

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, 1, 0));

        visited[0][0][0] = true;

        while(!queue.isEmpty()){

            Node next = queue.poll();

            if (next.y == N-1 && next.x == M-1){
                answer = Math.min(answer, next.distance);
                continue;
            }

            for (int i=0; i<4; i++){

                int ny = next.y + dy[i];
                int nx = next.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < M){

                    if (map[ny][nx] == '1' && next.wall == 0) {
                        visited[ny][nx][1] = true;
                        queue.add(new Node(ny, nx, next.distance + 1, 1));
                    }

                    else if (map[ny][nx] == '0' && !visited[ny][nx][next.wall]) {
                        visited[ny][nx][next.wall] = true;
                        queue.add(new Node(ny, nx, next.distance + 1, next.wall));
                    }
                }
            }
        }
    }
}