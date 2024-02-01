import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long[][] ingredients;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ingredients = new long[N][2]; // [0] : 신맛, [1] : 쓴맛
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            ingredients[i][0] = Long.parseLong(st.nextToken());
            ingredients[i][1] = Long.parseLong(st.nextToken());
        }

        pick(0, 1, 0);

        System.out.println(answer);
    }

    private static void pick(int index, long sour, long bitter) {


        if (index == N){

            if (bitter != 0 && Math.abs(sour-bitter) < answer)
                answer = Math.abs(sour - bitter);
            
            return;


        }

        pick(index + 1, sour * ingredients[index][0], bitter + ingredients[index][1]);

        pick(index+1, sour, bitter);
    }
}
