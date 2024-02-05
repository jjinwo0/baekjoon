import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> answer = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){

            for (int i=0; i<K-1; i++){
                queue.offer(queue.poll());
            }

            answer.offer(queue.poll());
        }

        sb.append("<");
        while(!answer.isEmpty()){
            sb.append(answer.poll()).append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");

        System.out.println(sb.toString());
    }
}
