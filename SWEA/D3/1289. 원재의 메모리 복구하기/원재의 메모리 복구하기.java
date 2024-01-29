import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){

            int count = 0;
            String error = br.readLine();
            String answer = "";

            for (int i=0; i<error.length(); i++){
                answer += String.valueOf(error.charAt(i));

                if (i == 0 && String.valueOf(error.charAt(i)).equals("1"))
                    count++;

                if (i > 0 && !String.valueOf(error.charAt(i)).equals(answer.substring(i-1, i)))
                    count++;
            }

            System.out.println("#"+test_case+" "+count);
        }
    }
}
