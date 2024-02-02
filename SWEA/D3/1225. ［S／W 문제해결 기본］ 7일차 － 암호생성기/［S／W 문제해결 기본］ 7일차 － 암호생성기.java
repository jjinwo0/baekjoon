import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;

        do{
            Queue<Integer> q = new LinkedList<>();
            T = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                q.add(Integer.parseInt(st.nextToken()));
            }

            for (int i=1; i<=5; i++){
                Integer poll = q.poll()-i;

                if (poll <= 0){
                    q.offer(0);
                    break;
                }

                if (i == 5)
                    i=0;

                q.offer(poll);
            }

            System.out.print("#" + T + " ");
            while(!q.isEmpty()) {
                System.out.print(q.poll() + " ");
            }

            System.out.println();

        }while(T<10);
    }
}
