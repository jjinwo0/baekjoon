import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer start = new StringBuffer(br.readLine());
        StringBuffer answer = new StringBuffer(br.readLine());

        while(answer.length() > start.length()){

            if (answer.charAt(answer.length()-1) == 'A')
                answer.deleteCharAt(answer.length() - 1);

            else if (answer.charAt(answer.length()-1) == 'B') {
                answer.deleteCharAt(answer.length() - 1);
                answer.reverse();
            }
        }

        if (answer.toString().equals(start.toString()))
            System.out.println(1);
        else System.out.println(0);
    }
}
