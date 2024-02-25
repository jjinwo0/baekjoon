import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> stack = new Stack<>();
        int[] homework = new int[2];
        int answer = 0;
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());

            int input = Integer.parseInt(st.nextToken());

            if (input == 0){

                if (homework[1] > 0){
                    homework[1] -= 1;

                    if (homework[1] == 0) {
                        answer += homework[0];

                        if (!stack.isEmpty())
                            homework = stack.pop();
                    }
                }

                continue;
            }

            if (input == 1){

                if (homework[1] > 0)
                    stack.push(homework);

                homework = new int[2];

                homework[0] = Integer.parseInt(st.nextToken());
                homework[1] = Integer.parseInt(st.nextToken()) - 1;

                if (homework[1] == 0) {
                    answer += homework[0];
                    if (!stack.isEmpty())
                        homework = stack.pop();
                }
            }
        }

        System.out.println(answer);
    }
}