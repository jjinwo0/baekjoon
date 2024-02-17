import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(game(N));
    }

    private static String game(int num) {

        int len = 3;
        int k = 0;

        if (num == 1){
            return "m";
        } else if (num <= 3){
            return "o";
        } else {
            while(len <= num){
                len = len * 2 + k + 4;
                k++;
            }

            int repeatSize = (len - (k + 3)) / 2;

            if (num > repeatSize && num <= repeatSize + k + 3) {
                return num == repeatSize + 1 ? "m" : "o";
            } else if (num <= repeatSize) {
                return game(num);
            } else {
                return game(num - repeatSize - k - 3);
            }
        }
    }
}
