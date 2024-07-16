import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Hongik {
        int nowN;
        int count;

        public Hongik(int nowN, int count) {
            this.nowN = nowN;
            this.count = count;
        }
    }

    static int T, G, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        bfs(new Hongik(N, 0));

        if (answer == Integer.MAX_VALUE) {
            System.out.println("ANG");
        } else {
            System.out.println(answer);
        }
    }

    private static void bfs(Hongik hongik) {
        Queue<Hongik> queue = new LinkedList<>();
        boolean[] visited = new boolean[100000];
        queue.offer(hongik);
        visited[hongik.nowN] = true;

        while (!queue.isEmpty()) {
            Hongik current = queue.poll();

            if (current.nowN == G) {
                answer = current.count;
                return;
            }

            if (current.count >= T) {
                continue;
            }

            int nextA = A(current.nowN);
            if (nextA < 100000 && !visited[nextA]) {
                queue.offer(new Hongik(nextA, current.count + 1));
                visited[nextA] = true;
            }

            int nextB = B(current.nowN);
            if (nextB < 100000 && !visited[nextB]) {
                queue.offer(new Hongik(nextB, current.count + 1));
                visited[nextB] = true;
            }
        }
    }

    public static int A(int n) {
        return n + 1;
    }

    public static int B(int n) {
        if (n == 0) return 0; // Edge case when n is 0

        int doubled = n * 2;
        if (doubled >= 100000) return 100000; // Avoid overflow

        char[] numChars = String.valueOf(doubled).toCharArray();
        numChars[0] = (char) (numChars[0] - 1);

        return Integer.parseInt(new String(numChars));
    }
}