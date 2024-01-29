import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P1 = Integer.parseInt(st.nextToken());
        int P2 = Integer.parseInt(st.nextToken());
        
        int count = 0;
        
        while(P1 != P2) {
            
            P1 = P1 / 2 + P1 % 2;
            P2 = P2 / 2 + P2 % 2;
            count++;
        }

        System.out.println(count);
    }
}
