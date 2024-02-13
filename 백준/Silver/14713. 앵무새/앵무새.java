import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<String> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Queue<String>> list = new ArrayList<>();

        for (int i=0; i<N; i++){
            Queue<String> temp = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                temp.offer(st.nextToken());
            }

            list.add(temp);
        }

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens())
            queue.offer(st.nextToken());

        for (int n=0; n<N; n++){

            int size = queue.size();

            for (int i=0; i<size; i++){
                if (queue.peek().equals(list.get(n).peek())) {
                    list.get(n).poll();
                    queue.poll();
                } else {
                    queue.offer(queue.poll());
                }
            }

            if (!list.get(n).isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }

        if (!queue.isEmpty()) {
            System.out.println("Impossible");
            return;
        }

        System.out.println("Possible");
    }
}
