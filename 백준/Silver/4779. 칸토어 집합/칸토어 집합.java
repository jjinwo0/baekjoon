import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while((str = br.readLine()) != null) {

            int N = Integer.parseInt(str);

            if (N == 0)
                System.out.println("-");
            else System.out.println(cantor(N));
        }
    }

    public static String cantor(int n){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (n == 0){
            return "-";
        }

        for (int i=0; i<Math.pow(3, n-1); i++){
            sb1.append(" ");
        }
        String answer = sb2.append(cantor(n - 1)).append(sb1).append(cantor(n - 1)).toString();

        return answer;
    }
}
