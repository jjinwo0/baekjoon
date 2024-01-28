import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            if (i == 0)
                stack.push(i);
        }

        for (int i=1; i<N; i++){

            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }

        for (int i=0; i<N; i++){
            sb.append(arr[i] + " ");
        }

        System.out.println(sb.toString());
    }
}
