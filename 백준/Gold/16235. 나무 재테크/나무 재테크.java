import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Tree implements Comparable<Tree>{
        int y;
        int x;
        int age;

        public Tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {

            return Integer.compare(this.age, o.age);
        }
    }

    static int N, M, K;

    static int[][] map, liveMap;

    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};

    static PriorityQueue<Tree> trees = new PriorityQueue<>();

    static ArrayList<Tree> deadTrees = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        liveMap = new int[N + 1][N + 1];

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                liveMap[i][j] = 5;
            }
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            trees.offer(new Tree(y, x, z));
        }

        for (int i=0; i<K; i++){

            spring();

            summer();

            autumn();

            winter();
        }

        System.out.println(trees.size());
    }

    private static void spring() {

        PriorityQueue<Tree> tempQueue = new PriorityQueue<>();
        int size = trees.size();

        for (int i=0; i<size; i++){

            Tree tree = trees.poll();

            if (liveMap[tree.y][tree.x] < tree.age) {
                deadTrees.add(tree);
                continue;
            }

            liveMap[tree.y][tree.x] -= tree.age;

            tree.age += 1;

            tempQueue.offer(tree);
        }

        trees = tempQueue;
    }

    private static void summer() {

        for (Tree tree : deadTrees){
            liveMap[tree.y][tree.x] += tree.age / 2;
        }

        deadTrees = new ArrayList<>();
    }

    private static void autumn() {

        ArrayList<Tree> newTrees = new ArrayList<>();
        for (Tree tree : trees) {
            if (tree.age % 5 == 0) {

                for (int k = 0; k < 8; k++) {

                    int ny = tree.y + dy[k];
                    int nx = tree.x + dx[k];

                    if (ny > 0 && ny <= N && nx > 0 && nx <= N) {
                        newTrees.add(new Tree(ny, nx, 1));
                    }
                }
            }
        }
        trees.addAll(newTrees);
    }

    private static void winter() {

        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                liveMap[i][j] += map[i][j];
            }
        }
    }
}