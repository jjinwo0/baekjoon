import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, answer;
    static char[][] map;
    static Queue<Node> queue = new LinkedList<>();
    static Queue<Node> fire = new LinkedList<>();
    static boolean[][] check;
    static boolean[][] fireCheck;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = -1;

        map = new char[R][C];

        check = new boolean[R][C];
        fireCheck = new boolean[R][C];

        for (int i=0; i<R; i++){
            String input = br.readLine();

            for (int j=0; j<C; j++){
                map[i][j] = input.charAt(j);

                if (map[i][j] == 'J')
                    queue.add(new Node(i, j, 1));

                if (map[i][j] == 'F')
                    fire.add(new Node(i, j, 0));
            }
        }

        escape();

        System.out.println(answer == -1 ? "IMPOSSIBLE":answer);
    }

    private static void escape() {

        while(!queue.isEmpty()){

            int fireSize = fire.size();

            for (int s=0; s<fireSize; s++){

                Node fireNode = fire.poll();

                for (int i=0; i<4; i++){
                    int nX = fireNode.x + dX[i];
                    int nY = fireNode.y + dY[i];

                    if (nX >= 0 && nY >= 0 && nX < C && nY < R && map[nY][nX] != '#' && !fireCheck[nY][nX]) {
                        fireCheck[nY][nX] = true;
                        map[nY][nX] = 'F';
                        fire.add(new Node(nY, nX, fireNode.move + 1));
                    }
                }
            }

            int size = queue.size();

            for (int s=0; s<size; s++) {

                Node jihoon = queue.poll();

                if (jihoon.x == 0 || jihoon.y == 0 || jihoon.x == C-1 || jihoon.y == R-1) {
                    answer = jihoon.move;
                    return;
                }

                for (int i=0; i<4; i++){
                    int nX = jihoon.x + dX[i];
                    int nY = jihoon.y + dY[i];

                    if (nX >= 0 && nY >= 0 && nX < C && nY < R && map[nY][nX] == '.' && !check[nY][nX]) {

                        if (nX == C - 1 || nY == R - 1 || nX == 0 || nY == 0) {
                            map[nY][nX] = 'J';
                            answer = jihoon.move + 1;
                            return;
                        }

                        check[nY][nX] = true;
                        map[nY][nX] = 'J';
                        queue.add(new Node(nY, nX, jihoon.move + 1));
                    }
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    int move;

    public Node(int y, int x, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
