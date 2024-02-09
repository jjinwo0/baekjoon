import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Integer[] arrA = new Integer[N];
        Integer[] arrB = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arrB[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arrA);
        Arrays.sort(arrB, (o1, o2) -> {
            return o2 - o1;
        });

        int answer = 0;
        for (int i=0; i<N; i++){
            answer += arrA[i] * arrB[i];
        }

        sb.append(answer);

        System.out.println(sb.toString());
    }
}
