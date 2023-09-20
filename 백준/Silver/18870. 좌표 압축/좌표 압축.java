import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            sorted[i] = arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int count = 0;
        for (int val : sorted){

            if (!map.containsKey(val)){

                map.put(val, count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int val : arr){
            sb.append(map.get(val)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
