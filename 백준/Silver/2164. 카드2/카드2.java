import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int N = sc.nextInt();

        for (int i=0; i<N; i++){
            queue.add(i+1);
        }

        while(queue.size()>1){
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
