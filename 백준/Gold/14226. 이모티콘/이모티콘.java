import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Emoticon {
        int clipboard;
        int length;
        int time;

        public Emoticon(int clipboard, int length, int time) {
            this.clipboard = clipboard;
            this.length = length;
            this.time = time;
        }
    }

    static int N;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        bfs();
    }

    private static void bfs() {

        Queue<Emoticon> queue = new LinkedList<>();
        visited = new boolean[1001][1001];

        queue.offer(new Emoticon(0, 1, 0));
        visited[0][1] = true;

        while(!queue.isEmpty()) {

            Emoticon now = queue.poll();

            if (now.length == N){
                System.out.println(now.time);
                return;
            }

            // 클립보드 저장
            queue.offer(new Emoticon(now.length, now.length, now.time + 1));

            if (now.clipboard != 0 && now.length + now.clipboard <= N && !visited[now.clipboard][now.clipboard + now.length]){
                queue.offer(new Emoticon(now.clipboard, now.clipboard + now.length, now.time + 1));
                visited[now.clipboard][now.clipboard + now.length] = true;
            }

            if (now.length >= 1 && !visited[now.clipboard][now.length-1]){
                queue.offer(new Emoticon(now.clipboard, now.length - 1, now.time + 1));
                visited[now.clipboard][now.length - 1] = true;
            }
        }
    }
}