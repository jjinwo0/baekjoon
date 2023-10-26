import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Node> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int map[][];
    static boolean visited[][];

    static int nowX, nowY;
    static int N, M, K;
    static int count;

    static class Node{

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            count = 0;
            for (int j=0; j<N; j++){
                for (int k=0; k<M; k++){

                    if (!visited[j][k] && map[j][k] == 1){
                        count++;
                        bfs(k, j);
                    }
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y){

        queue.offer(new Node(x, y));
        visited[y][x] = true;

        while(!queue.isEmpty()){

            Node node = queue.poll();

            for (int i=0; i<4; i++){

                nowX = node.x + dx[i];
                nowY = node.y + dy[i];

                if (nowX >= 0 && nowX < M && nowY >= 0 && nowY < N){

                    if (visited[nowY][nowX] == false && map[nowY][nowX] == 1) {
                        queue.offer(new Node(nowX, nowY));
                        visited[nowY][nowX] = true;
                    }
                }
            }
        }
    }
}
