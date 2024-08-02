import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int result = 0;
        
        for (int i=0; i<N; i++) {
            
            int left = 0;
            int right = N-1;
            
            while(true) {
                
                if (left == i) 
                    left++;
                
                else if (right == i)
                    right--;
                
                if (left >= right)
                    break;

                int temp = arr[left] + arr[right];
                
                if (temp > arr[i]) right--;
                else if (temp < arr[i]) left++;
                else {
                    result += 1;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}