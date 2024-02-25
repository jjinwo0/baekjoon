import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] button = new int[3];

        int T = Integer.parseInt(br.readLine());

        if (T % 10 != 0){
            System.out.println(-1);
            return;
        }

        button[0] = T / 300;
        T %= 300;

        button[1] = T / 60;
        T %= 60;

        button[2] = T / 10;
        T %= 10;

        for (int i=0; i<3; i++)
            System.out.print(button[i]+" ");
    }
}