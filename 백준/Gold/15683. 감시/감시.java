import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer;

    static ArrayList<CCTV> cctv = new ArrayList<>();

    static class CCTV {
        int y;
        int x;
        int type;

        public CCTV(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        int[][] map = new int[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0 && map[i][j] != 6)
                    cctv.add(new CCTV(i, j, map[i][j]));
            }
        }

        watch(map, 0);

        System.out.println(answer);
    }

    private static void watch(int[][] map, int count) {

        if (count == cctv.size()) {

            int zeroCount = getZero(map);

            answer = Math.min(zeroCount, answer);

            return;
        }

        CCTV get = cctv.get(count);
        int[][] copy;

        if (get.type == 1){

            copy = copyMap(map);

            checkLeft(copy, get.y, get.x);
            watch(copy, count + 1);

            copy = copyMap(map);

            checkRight(copy, get.y, get.x);
            watch(copy, count + 1);

            copy = copyMap(map);

            checkUp(copy, get.y, get.x);
            watch(copy, count + 1);

            copy = copyMap(map);

            checkDown(copy, get.y, get.x);
            watch(copy, count + 1);

        }
        if (get.type == 2){

            copy = copyMap(map);

            checkLeft(copy, get.y, get.x);
            checkRight(copy, get.y, get.x);
            watch(copy, count + 1);

            copy = copyMap(map);

            checkUp(copy, get.y, get.x);
            checkDown(copy, get.y, get.x);
            watch(copy, count + 1);
        }
        if (get.type == 3){

            copy = copyMap(map);

            checkUp(copy, get.y, get.x);
            checkRight(copy, get.y, get.x);
            watch(copy, count + 1);

            copy = copyMap(map);

            checkRight(copy, get.y, get.x);
            checkDown(copy, get.y, get.x);
            watch(copy, count + 1);

            copy = copyMap(map);

            checkDown(copy, get.y, get.x);
            checkLeft(copy, get.y, get.x);
            watch(copy, count + 1);

            copy = copyMap(map);

            checkLeft(copy, get.y, get.x);
            checkUp(copy, get.y, get.x);
            watch(copy, count + 1);
        }
        if (get.type == 4){

            copy = copyMap(map);

            checkLeft(copy, get.y, get.x);
            checkUp(copy, get.y, get.x);
            checkRight(copy, get.y, get.x);
            watch(copy, count + 1);

            copy = copyMap(map);

            checkUp(copy, get.y, get.x);
            checkRight(copy, get.y, get.x);
            checkDown(copy, get.y, get.x);
            watch(copy, count + 1);

            copy = copyMap(map);

            checkLeft(copy, get.y, get.x);
            checkDown(copy, get.y, get.x);
            checkRight(copy, get.y, get.x);
            watch(copy, count + 1);

            copy = copyMap(map);

            checkUp(copy, get.y, get.x);
            checkLeft(copy, get.y, get.x);
            checkDown(copy, get.y, get.x);
            watch(copy, count + 1);
        }
        if (get.type == 5){

            copy = copyMap(map);

            checkLeft(copy, get.y, get.x);
            checkUp(copy, get.y, get.x);
            checkRight(copy, get.y, get.x);
            checkDown(copy, get.y, get.x);
            watch(copy, count + 1);
        }
    }

    private static void checkDown(int[][] map, int y, int x) {

        for (int i=y; i<N; i++){

            if (map[i][x] == 6)
                break;

            if (map[i][x] == 0)
                map[i][x] = -1;
        }
    }

    private static void checkUp(int[][] map, int y, int x) {

        for (int i=y; i>=0; i--){

            if (map[i][x] == 6)
                break;

            if (map[i][x] == 0)
                map[i][x] = -1;
        }
    }

    private static void checkRight(int[][] map, int y, int x) {

        for (int i=x; i<M; i++){

            if (map[y][i] == 6)
                return;

            if (map[y][i] == 0)
                map[y][i] = -1;
        }
    }

    private static void checkLeft(int[][] map, int y, int x) {

        for (int i=x; i>=0; i--){

            if (map[y][i] == 6)
                return;

            if (map[y][i] == 0)
                map[y][i] = -1;

        }
    }

    private static int getZero(int[][] map) {

        int count = 0;

        for (int i=0; i<map.length; i++){
            for (int j=0; j<map[i].length; j++){

                if (map[i][j] == 0)
                    count++;
            }
        }

        return count;
    }

    private static int[][] copyMap(int[][] map) {

        int[][] temp = new int[N][M];

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                temp[i][j] = map[i][j];
            }
        }

        return temp;
    }
}