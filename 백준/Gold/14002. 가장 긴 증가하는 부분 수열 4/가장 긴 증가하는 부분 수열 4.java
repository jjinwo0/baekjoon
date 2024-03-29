import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] LIS = new int[N];
        int[] trace = new int[N];

        Arrays.fill(LIS, Integer.MAX_VALUE);

        int length = 0;

        for (int i=0; i<N; i++){

            int pos = Arrays.binarySearch(LIS, 0, length, arr[i]);

            if (pos < 0) // pos가 음수라면, 들어갈 위치가 없음을 의미
                pos = -pos - 1; // 따라서, 삽입index를 음수로 변경한 후, -1을 하여 들어갈 인덱스를 양수로 전환해줌

            LIS[pos] = arr[i];
            trace[i] = pos;

            if (pos == length)
                length++;
        }

        sb.append(length).append("\n");

        Stack<Integer> stack = new Stack<>();
        int target = length - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (trace[i] == target) {
                stack.push(arr[i]);
                target--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }
}