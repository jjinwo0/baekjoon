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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] edge = new int[N+1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++){

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
        }

        for (int i=1; i<=N; i++){
            ArrayList<Integer> nodes = list.get(i);

            for (Integer node : nodes) {
                edge[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<=N; i++){
            if (edge[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){

            Integer index = queue.poll();

            sb.append(index).append(" ");

            ArrayList<Integer> nodes = list.get(index);

            for (Integer node : nodes) {
                edge[node]--;

                if (edge[node] == 0)
                    queue.add(node);
            }
        }

        System.out.println(sb);
    }
}