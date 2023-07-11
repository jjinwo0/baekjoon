import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(true){
            if (N%5 == 0) {
                System.out.println(cnt + N/5);
                break;
            }else if (N < 0){
                System.out.println(-1);
                break;
            }
            N -= 3;
            cnt++;
        }
    }
}
