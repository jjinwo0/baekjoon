import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class SCV {

        int first;
        int second;
        int third;
        int value;

        public SCV(int first, int second, int third, int value) {
            this.first = first;
            this.second = second;
            this.third = third;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] scv = new int[3];

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        bfs(scv);
    }

    private static void bfs(int[] scv) {

        Queue<SCV> queue = new LinkedList<>();
        
        int[][][] dp = new int[61][61][61];
        boolean[][][] visited = new boolean[61][61][61];
        int[][] damage = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
        
        visited[0][0][0] = true;

        queue.offer(new SCV(0, 0, 0, 0));
        
        while(!queue.isEmpty()) {
            
            SCV curScv = queue.poll();
            
            for (int i=0; i<6; i++){
                
                int nextFirst = curScv.first + damage[i][0];
                int nextSecond = curScv.second + damage[i][1];
                int nextThird = curScv.third + damage[i][2];
                
                if (nextFirst > 60) nextFirst = 60;
                if (nextSecond > 60) nextSecond = 60;
                if (nextThird > 60) nextThird = 60;
                
                if (visited[nextFirst][nextSecond][nextThird]) continue;
                
                if (nextFirst >= scv[0] && nextSecond >= scv[1] && nextThird >= scv[2]) {
                    System.out.println(curScv.value + 1);
                    return;
                }
                
                visited[nextFirst][nextSecond][nextThird] = true;
                queue.offer(new SCV(nextFirst, nextSecond, nextThird, curScv.value + 1));
            }
        }
    }
}