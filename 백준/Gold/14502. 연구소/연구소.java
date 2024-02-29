import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int y; int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, answer, virusCount, blockCount;

    static int[][] map;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static ArrayList<Node> blockList = new ArrayList<>();

    static ArrayList<Node> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answer = -1;
        virusCount = Integer.MAX_VALUE;
        blockCount = 3;

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0)
                    blockList.add(new Node(i, j));

                if (map[i][j] == 1)
                    blockCount++;

                if (map[i][j] == 2)
                    virus.add(new Node(i, j));
            }
        }

        setWall(0, 0);

        System.out.println(answer);
    }

    private static void setWall(int start, int depth) {

        if (depth == 3){
            bfs();
            return;
        }

        for (int i=start; i<blockList.size(); i++){
            Node node = blockList.get(i);

            if (map[node.y][node.x] == 0) {
                map[node.y][node.x] = 1;
                setWall(start + 1, depth + 1);
                map[node.y][node.x] = 0;
            }
        }
    }

    private static void bfs() {

        Queue<Node> queue = new LinkedList<>();

        int temp = 0;

        int[][] tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        for (Node v : virus) {
            queue.offer(v);
        }

        while(!queue.isEmpty()){

            Node virus = queue.poll();

            for (int i=0; i<4; i++){
                int ny = virus.y + dy[i];
                int nx = virus.x + dx[i];

                if (ny >= 0 && nx >= 0 && ny < N && nx < M && tempMap[ny][nx] == 0){
                    tempMap[ny][nx] = 2;
                    queue.offer(new Node(ny, nx));
                }
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (tempMap[i][j] == 0)
                    temp++;
            }
        }

        answer = Math.max(answer, temp);
    }
}