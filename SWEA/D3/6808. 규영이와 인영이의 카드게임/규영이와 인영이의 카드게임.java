import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static ArrayList<Integer> gyu, in;
    static boolean[] check;
    static int gScore, iScore;
    static int winCount, loseCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case=1; test_case<=T; test_case++){

            gyu = new ArrayList<>();
            in = new ArrayList<>();
            check = new boolean[9];
            gScore = 0; iScore = 0;
            winCount = 0; loseCount = 0;

            st = new StringTokenizer(br.readLine());

            for (int i=1; i<=9; i++){
                gyu.add(Integer.parseInt(st.nextToken()));
            }

            for (int i=1; i<=18; i++){
                if (gyu.contains(i))
                    continue;

                in.add(i);
            }

            dfs(0,  0, 0, 0);

            sb.append("#"+test_case+" "+winCount+" "+loseCount).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int index, int depth, int win, int lose) {

        if (depth == 9){
            if (lose < win)
                winCount++;
            else loseCount++;

            return;
        }

        for (int i=0; i<gyu.size(); i++){
            if (!check[i]){
                check[i] = true;

                if (gyu.get(i) > in.get(index)) {
                    dfs(index + 1, depth + 1, win + in.get(index) + gyu.get(i), lose);
                } else{
                    dfs(index + 1, depth + 1, win, lose + gyu.get(i) + in.get(index));
                }

                check[i] = false;
            }
        }
    }
}