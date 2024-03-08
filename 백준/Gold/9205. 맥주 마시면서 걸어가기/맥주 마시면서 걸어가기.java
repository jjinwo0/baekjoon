import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Move {
        int y;
        int x;
        int beerCount;

        public Move(int y, int x, int beerCount) {
            this.y = y;
            this.x = x;
            this.beerCount = beerCount;
        }
    }

    static int N;

    static int[] festival;
    static boolean[] visited;
    static int[][] store;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] start = new int[2];
            festival = new int[2];
            visited = new boolean[N];

            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            store = new int[N][2];

            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                store[i][0] = Integer.parseInt(st.nextToken());
                store[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            festival[0] = Integer.parseInt(st.nextToken());
            festival[1] = Integer.parseInt(st.nextToken());

            bfs(start);
        }
    }

    private static void bfs(int[] start) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);

        while(!queue.isEmpty()){
            int[] poll = queue.poll();

            if (Math.abs(poll[0] - festival[0]) + Math.abs(poll[1] - festival[1]) <= 1000){
                System.out.println("happy");
                return;
            }

            for (int i=0; i<N; i++){
                if (!visited[i] && Math.abs(poll[0] - store[i][0]) + Math.abs(poll[1] - store[i][1]) <= 1000){
                    queue.offer(new int[]{store[i][0], store[i][1]});
                    visited[i] = true;
                }
            }
        }

        System.out.println("sad");
    }
}