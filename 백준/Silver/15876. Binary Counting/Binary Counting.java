import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String binary = "";

        for (int i=0; i<100; i++){
            binary += Integer.toBinaryString(i);
        }

        for (int j=k-1; j<n*5; j+=n){
            sb.append(binary.charAt(j)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
