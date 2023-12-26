import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int current = 0;
        int pick = 0;

        while (pick++ <= Integer.MAX_VALUE) {
            String temp = String.valueOf(pick);

            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == str.charAt(current))
                    current++;

                if (current == str.length()) {
                    System.out.println(pick);
                    return ;
                }
            }
        }
    }
}
