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
        int K = Integer.parseInt(st.nextToken());
        int P = 2;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=2; i<=N; i++){
            list.add(i);
        }
        while(true) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % P == 0) {
                    K--;

                    if (K == 0){
                        System.out.println(list.get(i));
                        return;
                    }
                    list.remove(i);
                }
            }
            P = list.get(0);
        }
    }
}
