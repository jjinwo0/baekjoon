import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String answer = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alphabet = new int[26];

        for (int i=0; i<str.length(); i++){

            alphabet[str.charAt(i)-'A']++; // 알파벳 종류별 갯수 저장
        }

        int one = 0;

        for (int i=0; i<alphabet.length; i++){

            if (alphabet[i] % 2 != 0) // 홀수 갯수 알파벳 검증
                one++;
        }

        StringBuilder sb = new StringBuilder();

        if (one > 1)
            answer += "I'm Sorry Hansoo";

        else{

            for (int i=0; i<alphabet.length; i++){

                for (int j=0; j<alphabet[i] / 2; j++){

                    sb.append((char) (i + 65));
                }
            }

            answer += sb.toString();
            String temp = sb.reverse().toString();

            sb = new StringBuilder();

            for (int i=0; i<alphabet.length; i++){

                if (alphabet[i] % 2 == 1)
                    sb.append((char) (i + 65));
            }

            answer += sb.toString() + temp;
        }

        System.out.println(answer);
    }
}
