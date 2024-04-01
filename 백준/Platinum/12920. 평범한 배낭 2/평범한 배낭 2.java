import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(0, 0));

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int temp = 1;

            while(temp <= K){

                list.add(new Item(V * temp, C * temp));

                K -= temp;

                temp *= 2;
            }

            if (K != 0)
                list.add(new Item(V * K, C * K));
        }

        int[][] dp = new int[list.size() + 1][M + 1];

        for (int i=1; i<list.size(); i++){

            for (int j=1; j<=M; j++) {

                if (j < list.get(i).weight)
                    dp[i][j] = dp[i - 1][j];

                else
                    dp[i][j] = Math.max(dp[i - 1][j], list.get(i).value + dp[i - 1][j - list.get(i).weight]);
            }
        }

        System.out.println(dp[list.size()-1][M]);
    }
}