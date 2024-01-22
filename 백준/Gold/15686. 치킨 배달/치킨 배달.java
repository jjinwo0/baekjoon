import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer;
    static int[][] map;
    static List<Node> house = new ArrayList<>();
    static List<Node> chicken = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1)
                    house.add(new Node(i, j));

                if (map[i][j] == 2)
                    chicken.add(new Node(i, j));
            }
        }

        answer = Integer.MAX_VALUE;
        check = new boolean[chicken.size()];
        
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int s, int m) {

        if (m == M){
            int result = 0;

            for (int i=0; i< house.size(); i++){

                int temp = Integer.MAX_VALUE;

                for (int j=0; j< chicken.size(); j++) {

                    if (check[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance);
                    }
                }

                result += temp;
            }

            answer = Math.min(result, answer);
            return;
        }

        for (int i=s; i< chicken.size(); i++){
            check[i] = true;
            dfs(i+1, m+1);
            check[i] = false;
        }
    }
}

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}