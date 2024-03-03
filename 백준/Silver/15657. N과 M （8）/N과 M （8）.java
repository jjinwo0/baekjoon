import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] answer;
    static int[] num;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        combi(0, 0);
    }

    private static void combi(int index, int depth) {

        if (depth == M){

            for (int n : answer)
                System.out.print(n + " ");
            System.out.println();
            return;
        }

        for (int i=index; i<N; i++){
            answer[depth] = num[i];
            combi(i, depth+1);
        }
    }
}