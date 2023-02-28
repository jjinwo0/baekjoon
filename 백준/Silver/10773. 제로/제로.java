import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt();
        for (int i=0; i<n; i++){
            int tmp = sc.nextInt();
            if (tmp == 0)
                stack.pop();
            else {
                stack.push(tmp);
            }
        }
        int sum = 0;
        for (int i=0; i< stack.size(); i++){
            sum += stack.get(i);
        }
        System.out.println(sum);
    }
}
