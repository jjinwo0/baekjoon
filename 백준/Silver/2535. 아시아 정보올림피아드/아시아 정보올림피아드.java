import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, ((o1, o2) -> o2[2]-o1[2]));

        int count = 0;
        for (int i=0; i<arr.length; i++){
            map.put(arr[i][0], map.getOrDefault(arr[i][0], 0) + 1);

            if (map.get(arr[i][0]) > 2)
                continue;

            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
            count++;

            if (count == 3)
                break;
        }

        System.out.println(sb);
    }
}