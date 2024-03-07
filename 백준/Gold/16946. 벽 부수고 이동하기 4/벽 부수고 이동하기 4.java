import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static int[][] map, group;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visited;

    static int[] groupSize;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0; i<N; i++){
            String[] split = br.readLine().split("");

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int num = 0;
        groupSize = new int[N * M + 1];
        visited = new boolean[N][M];
        group = new int[N][M];

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (map[i][j] == 0 && !visited[i][j]){
                    groupSize[++num] = bfs(i, j, num);
                }
            }
        }

        bfs2();

        System.out.println(sb);
    }

    private static void bfs2() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int total = 1;
                    Set<Integer> uniqueGroups = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if (nx >= 0 && nx < M && ny >= 0 && ny < N && !uniqueGroups.contains(group[ny][nx])) {
                            uniqueGroups.add(group[ny][nx]);
                            total += groupSize[group[ny][nx]];
                        }
                    }
                    sb.append(total % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
    }

    private static int bfs(int y, int x, int num) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        visited[y][x] = true;
        group[y][x] = num;
        
        int count = 1;
        while (!queue.isEmpty()) {

            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = point[1] + dx[i];
                int ny = point[0] + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx] == 0 && !visited[ny][nx]) {

                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    group[ny][nx] = num;
                    count++;
                }
            }
        }

        return count;
    }
}