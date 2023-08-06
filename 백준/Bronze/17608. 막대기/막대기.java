import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<N; i++){
            stack.push(sc.nextInt());
        }

        int count = 1;
        int last = stack.pop();

        while(!stack.isEmpty()){
            int next = stack.pop();
            if (last < next) {
                count++;
                last = next;
            }
        }

        System.out.println(count);
    }
}
