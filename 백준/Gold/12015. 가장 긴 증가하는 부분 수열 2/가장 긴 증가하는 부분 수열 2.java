import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] LIS = new int[N];

        int length = 0;

        for (int i=0; i<N; i++){

            int pos = Arrays.binarySearch(LIS, 0, length, arr[i]);

            if (pos < 0) // pos가 음수라면, 들어갈 위치가 없음을 의미
                pos = -pos - 1; // 따라서, 삽입index를 음수로 변경한 후, -1을 하여 들어갈 인덱스를 양수로 전환해줌

            LIS[pos] = arr[i];

            if (pos == length)
                length++;
        }

        System.out.println(length);
    }
}