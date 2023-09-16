import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int answer = 0;

        for (int i=0; i<arr.length-1; i++){

            for (int j=i+1; j<arr.length; j++){

                if (Integer.parseInt(arr[i]) + Integer.parseInt(arr[j]) == M)
                    answer++;
            }
        }

        System.out.println(answer);
    }
}
