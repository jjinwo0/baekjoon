import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    static Queue<Integer> queue;
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {

            N = Integer.parseInt(br.readLine());

            queue = new LinkedList<>();
            arr = new int[101];

            int i=0;
            while (true){

                queue.offer(++i);
                Integer poll = queue.poll();
                arr[poll] = arr[poll] + 1;
                N -= arr[poll];

                if (N <= 0){
                    System.out.println("#"+test_case+" "+poll);
                    break ;
                }

                queue.offer(poll);
            }
        }
    }
}
