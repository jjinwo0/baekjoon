import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        int answer = 0;
        int count = 1;

        for (int i=0; i<str.length(); i++){

            char temp = str.charAt(i);

            if (temp == '['){
                stack.push(temp);
                count *= 3;
            }

            if (temp == '('){
                stack.push(temp);
                count *= 2;
            }

            if (temp == ']'){
                if (stack.isEmpty() || stack.peek() != '['){
                    answer = 0;
                    break;
                }
                if (str.charAt(i-1) == '[')
                    answer += count;

                stack.pop();
                count /= 3;
            }

            if (temp == ')'){
                if (stack.isEmpty() || stack.peek() != '('){
                    answer = 0;
                    break;
                }
                if (str.charAt(i-1) == '(')
                    answer += count;

                stack.pop();
                count /= 2;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(answer);
    }
}
