import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] number = new int[N.length()];
        int addNumbers = 0;

        for (int i=0; i<number.length; i++){
            number[i] = Integer.parseInt(N.substring(i, i+1));
            addNumbers += number[i];
        }

        Arrays.sort(number);

        if (addNumbers % 3 == 0 && number[0] == 0){
            for (int i=number.length-1; i>=0; i--){
                System.out.print(number[i]);
            }
        }else
            System.out.println(-1);
    }
}
