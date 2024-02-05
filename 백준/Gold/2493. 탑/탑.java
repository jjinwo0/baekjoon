import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<int[]> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++){
            int temp = Integer.parseInt(st.nextToken());

            while(true) {
                if (!stack.isEmpty()) {

                    Integer top = stack.peek()[0];

                    if (top > temp) {

                        System.out.print(stack.peek()[1] + " ");
                        stack.push(new int[]{temp, i});
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    System.out.print("0 ");
                    stack.push(new int[]{temp, i});
                    break;
                }
            }
        }
    }
}
