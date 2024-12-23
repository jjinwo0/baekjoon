import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    static int[][] weddingArray;
    static Set<Integer> inviteSet = new HashSet<>();
    static int n;

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        weddingArray = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            weddingArray[a][b] = 1;
            weddingArray[b][a] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            if (i != 1) {
                if (weddingArray[1][i] == 1) {
                    bfs(i);
                }
            }
        }

        bw.write(inviteSet.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private void bfs(int i) {
        inviteSet.add(i);

        for (int index = 0; index < n + 1; index++) {
            if (weddingArray[i][index] == 1 && index != 1) {
                inviteSet.add(index);
            }
        }
    }
}