import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> value = new Stack<>();
        Stack<Integer> index = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++){
            int temp = Integer.parseInt(st.nextToken());

            while(true) {
                if (!value.isEmpty()) {

                    Integer top = value.peek();

                    if (top > temp) {

                        System.out.print(index.peek() + " ");
                        value.push(temp);
                        index.push(i);
                        break;
                    } else {
                        value.pop();
                        index.pop();
                    }
                } else {
                    System.out.print("0 ");
                    value.push(temp);
                    index.push(i);
                    break;
                }
            }
        }
    }
}
