import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case=1; test_case<=10; test_case++){
            int length = Integer.parseInt(br.readLine());
            int answer = 0;

            Stack<Character> stack = new Stack<>();

            char[] str = br.readLine().toCharArray();

            for (int i=0; i<length; i++){

                char temp = str[i];

                // 열린 괄호가 들어오면 무조건 push
                if (temp == '(' || temp == '[' || temp == '{' || temp == '<') {
                    stack.push(temp);
                    continue;
                }

                // 열린 괄호가 아닌데 stack이 비어있으면 뒤를 확인하지 않아도 됨
                if (stack.isEmpty() ||
                        (temp == ']' && stack.peek() != '[') ||
                        (temp == '}' && stack.peek() != '{') ||
                        (temp == ')' && stack.peek() != '(') ||
                        (temp == '>' && stack.peek() != '<')){
                    break;
                }

                if (temp == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }

                if (temp == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }

                if (temp == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }

                if (temp == '>' && stack.peek() == '<') {
                    stack.pop();
                }
            }

            if (stack.isEmpty())
                answer = 1;

            System.out.println("#"+test_case+" "+answer);
        }
    }
}
