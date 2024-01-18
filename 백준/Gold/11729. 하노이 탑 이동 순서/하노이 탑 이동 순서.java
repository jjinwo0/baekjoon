import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);

        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static void hanoi(int N, int start, int mid, int end){

        if (N == 1){
            sb.append(start+" "+end).append("\n");
            count++;
            return;
        }

        count++;

        hanoi(N-1, start, end, mid); // N-1까지를 mid로 옮겨두고,

        sb.append(start+" "+end).append("\n"); // N번째 원반을 end로 옮기고, (+출력)

        hanoi(N-1, mid, start, end); // mid로 옮겨둔 나머지 N-1을 end로 옮긴다.
    }
}
