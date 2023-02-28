import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        while(true) {
            String str = sc.nextLine();
            if (str.equals("."))
                break;
            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                if (temp == '(' || temp == '[') {
                    stack.push(temp);
                } else if (temp == ')' || temp == ']') {
                    if (stack.isEmpty() ||
                            (stack.peek() == '(' && temp == ']') ||
                            (stack.peek() == '[' && temp == ')')){
                        stack.push(temp);
                        break;
                    }else stack.pop();
                }
            }
            if (stack.isEmpty())
                System.out.println("yes");
            else System.out.println("no");
            stack.clear();
        }
    }
}