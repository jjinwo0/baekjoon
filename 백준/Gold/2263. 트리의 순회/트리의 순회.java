import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] in, post;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        post = new int[N];
        in = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int x = 0; x < N; x++) {
            in[x] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < N; x++) {
            post[x] = Integer.parseInt(st.nextToken());
        }
        preOrder(N-1, 0, N);
    }

    static void preOrder(int root, int start, int end) {

        for (int i=start; i<end; i++){
            if (in[i] == post[root]){
                System.out.print(in[i]+" ");
                preOrder(root-end+i, start, i);
                preOrder(root-1, i+1, end);
            }
        }
    }
}

