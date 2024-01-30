import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] map, things;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[101];
        things = new int[101];
        visited = new boolean[101];

        for (int i=0; i<N+M; i++){

            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            things[index] = value;
        }

        for (int i=1; i<map.length; i++){

            if (things[i] != 0) {

                map[i] = things[i];
                continue;
            }

            map[i] = i;
        }

        bfs(1);
    }

    private static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        int count = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i=0; i<size; i++){

                Integer now = queue.poll();

                for (int j=1; j<=6; j++){

                    if (now + j > 100 || visited[map[now+j]])
                        continue;

                    if (map[now + j] == 100) {
                        System.out.println(count);
                        return ;
                    }

                    visited[now+j] = true;
                    visited[map[now+j]] = true;
                    queue.add(map[now+j]);
                }
            }
            count++;
        }
    }
}
