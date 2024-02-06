import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(makeMax(str));
        System.out.println(makeMin(str));
    }

    private static String makeMax(String str) {

        String answer = "";

        int count = 0;
        for (int i=0; i<str.length(); i++){

            if (str.charAt(i) == 'M'){
                count++;
            }
            if (str.charAt(i) == 'K'){

                if (i == 0 || (i > 0 && str.charAt(i-1) == 'K'))
                    answer += "5";

                if (i > 0 && count != 0 && str.charAt(i-1) == 'M'){
                    answer += "5";

                    for (int k=0; k<count; k++){
                        answer += "0";
                    }

                    count = 0;
                }
            }
        }

        if (count != 0){
            for (int i=0; i<count; i++){
                answer += "1";
            }
        }

        return answer;
    }

    private static String makeMin(String str) {

        String answer = "";

        for (int i=0; i<str.length(); i++){

            if (str.charAt(i) == 'M'){
                if (answer != "" && str.charAt(i-1) == 'M')
                    answer += "0";

                else answer += "1";
            }

            if (str.charAt(i) == 'K'){
                answer += "5";
            }
        }

        return answer;
    }
}