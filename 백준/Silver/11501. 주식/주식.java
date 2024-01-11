import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){

            int N = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");

            int max = Integer.parseInt(arr[N-1]);
            long answer = 0;

            for (int j=N-2; j>=0; j--){
                if (max < Integer.parseInt(arr[j]))
                    max = Integer.parseInt(arr[j]);
                else answer += max - Integer.parseInt(arr[j]);
            }
            System.out.println(answer);
        }
    }
}
