import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<n; i++){
            String temp = String.valueOf(br.readLine());
            stack.push(temp.charAt(0));
            for (int j=1; j<temp.length(); j++){
                if (stack.size() == 0 || stack.peek() != temp.charAt(j))
                    stack.push(temp.charAt(j));
                else stack.pop();
            }
            if (stack.isEmpty())
                answer++;
            stack.clear();
        }
        System.out.println(answer);
    }
}