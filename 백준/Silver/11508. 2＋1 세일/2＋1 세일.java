import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        Arrays.sort(arr, Comparator.reverseOrder());
        int sum = 0;
        for (int i = 0; i < num; i++) {
            if((i+1) % 3 == 0) continue;

            sum+= arr[i];
        }

        System.out.println(sum);
    }
}