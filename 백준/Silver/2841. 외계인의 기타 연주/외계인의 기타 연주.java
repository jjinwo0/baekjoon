import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] guitar = new Stack[N];

        for (int i=0; i<N; i++){
            guitar[i] = new Stack<>();
        }

        int count = 0;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            if (guitar[index].isEmpty()){
                count++;
                guitar[index].push(value);
                continue;
            }

            while(guitar[index].peek() > value){
                guitar[index].pop();
                count++;

                if (guitar[index].size()==0)
                    break;
            }

            if (guitar[index].isEmpty() || guitar[index].peek() != value) {
                guitar[index].push(value);
                count++;
            }
        }

        System.out.println(count);
    }
}
