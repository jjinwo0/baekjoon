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

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        int[] edge = new int[N + 1];

        for (int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++){

            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken());
            int[] arr = new int[size];

            for (int k=0; k<size; k++){
                arr[k] = Integer.parseInt(st.nextToken());
            }

            for (int k=0; k<size-1; k++){
                list.get(arr[k]).add(arr[k+1]);
                edge[arr[k+1]]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<=N; i++){

            if (edge[i] == 0)
                queue.add(i);
        }

        while(!queue.isEmpty()){

            Integer index = queue.poll();
            sb.append(index).append("\n");

            ArrayList<Integer> nodes = list.get(index);

            for (Integer node : nodes){
                edge[node]--;

                if (edge[node] == 0)
                    queue.add(node);
            }
        }

        for (int i=1; i<edge.length; i++){
            if (edge[i] != 0){
                System.out.println(0);
                return;
            }
        }

        System.out.println(sb);
    }
}