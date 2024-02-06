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

        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i=0; i<str.length(); i++){

            if (str.charAt(i) == 'M'){
                count++;
            }
            if (str.charAt(i) == 'K'){

                if (i == 0 || (i > 0 && str.charAt(i-1) == 'K'))
                    sb.append("5");

                if (i > 0 && count != 0 && str.charAt(i-1) == 'M'){
                    sb.append("5");

                    for (int k=0; k<count; k++){
                        sb.append("0");
                    }

                    count = 0;
                }
            }
        }

        if (count != 0){
            for (int i=0; i<count; i++){
                sb.append("1");
            }
        }

        return sb.toString();
    }

    private static String makeMin(String str) {

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<str.length(); i++){

            if (str.charAt(i) == 'M'){
                if (!sb.toString().isEmpty() && str.charAt(i-1) == 'M')
                    sb.append("0");

                else sb.append("1");
            }

            if (str.charAt(i) == 'K'){
                sb.append("5");
            }
        }

        return sb.toString();
    }
}