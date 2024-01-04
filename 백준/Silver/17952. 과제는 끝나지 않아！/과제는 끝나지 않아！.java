import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Task> stack = new Stack<>();

        int score = 0;

        for (int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            Task task = null;

            if (input.length > 1){

                task = new Task(Integer.parseInt(input[1]), Integer.parseInt(input[2])-1);
                stack.push(task);
            } else {
                if (!stack.isEmpty()){
                    task = stack.peek();
                    task.time--;
                }
            }

            if (!stack.isEmpty() && task.time == 0){
                score += task.score;
                stack.pop();
            }
        }

        System.out.println(score);
    }
}

class Task{

    int score;
    int time;

    public Task(int score, int time) {
        this.score = score;
        this.time = time;
    }
}
