import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while(true){

            if (N < 0){
                System.out.println(-1);
                break;
            }

            if (N % 5 == 0){
                System.out.println(count + N/5);
                break;
            }

            count++;
            N-=3;
        }
    }
}