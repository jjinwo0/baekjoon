import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> trees = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = -1;

        for (int i = 0; i < N; i++) {
            trees.add(Integer.parseInt(st.nextToken()));
            right = Math.max(trees.get(i), right);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            long tree = 0;

            for (int i = 0; i < N; i++) {
                if (trees.get(i) > mid)
                    tree += trees.get(i) - mid;
            }
            if (tree >= M) {
                left = mid + 1;
            } else
                right = mid - 1;

        }

        System.out.println(right);
    }
}
