import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<str.length(); j++){
                char c = str.charAt(j);

                if (c == '(')
                    stack.push(c);
                else if(c == ')'){
                    if (stack.isEmpty()){
                        stack.push(c); // )가 추가됨으로써 empty 검사 시 반드시 NO
                        break;
                    } else stack.pop();
                }
            }

            if (stack.isEmpty())
                System.out.println("YES");
            else System.out.println("NO");
            
            stack.clear();
        }
    }
}