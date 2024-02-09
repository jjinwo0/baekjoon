import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, answer;
    static String[][] map;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};
    static boolean[][] check;
    static Queue<Node> queue = new LinkedList<>();
    static Queue<Node> rain = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        check = new boolean[R][C];
        answer = -1;

        for (int i=0; i<R; i++){
            String[] put = br.readLine().split("");

            for (int j=0; j<C; j++){
                map[i][j] = put[j];

                if (map[i][j].equals("S")) {
                    queue.add(new Node(i, j, 0));
                }

                if (map[i][j].equals("*")){
                    rain.add(new Node(i, j, 0));
                }
            }
        }

        bfs();

        System.out.println(answer == -1 ? "KAKTUS" : answer);
    }

    private static void bfs() {

        while(!queue.isEmpty()){

            wideRain();

            int size = queue.size();
            for (int n=0; n<size; n++) {
                Node node = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nY = node.y + dY[i];
                    int nX = node.x + dX[i];

                    if (nY >= 0 && nX >= 0 && nY < R && nX < C) {

                        if (map[nY][nX].equals("D")) {
                            answer = node.move + 1;
                            return;
                        }

                        if (map[nY][nX].equals(".")) {
                            map[nY][nX] = "S";
                            queue.add(new Node(nY, nX, node.move + 1));
                        }
                    }
                }
            }
        }
    }

    private static void wideRain() {

        int length = rain.size();

        for (int r=0; r<length; r++) {

            Node rainNode = rain.poll();

            for (int i = 0; i < 4; i++) {
                int nY = rainNode.y + dY[i];
                int nX = rainNode.x + dX[i];

                if (nY >= 0 && nX >= 0 && nY < R && nX < C && map[nY][nX].equals(".")) {
                    map[nY][nX] = "*";
                    rain.add(new Node(nY, nX, rainNode.move + 1));
                }
            }
        }
    }
}

class Node {
    int y;
    int x;
    int move;

    public Node(int y, int x, int move) {
        this.y = y;
        this.x = x;
        this.move = move;
    }
}
