import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[101][101];
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            for (int y = Y; y < Y + 10; y++) {
                for (int x = X; x < X + 10; x++) {
                    map[y][x] = 1;
                }
            }
        }

        for (int y = 1; y <= 100; y++) {
            for (int x = 1; x <= 100; x++) {
                if (map[y][x] == 1) {
                    if (map[y - 1][x] == 0) count++;
                    if (map[y + 1][x] == 0) count++;
                    if (map[y][x - 1] == 0) count++;
                    if (map[y][x + 1] == 0) count++;
                }
            }
        }

        System.out.println(count);
    }
}