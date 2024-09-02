import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<N-1; i++) {

            st = new StringTokenizer(br.readLine());

            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            graph.get(U).add(V);
            graph.get(V).add(U);
        }

        int leaf = 0;
        
        for (int i=2; i<=N; i++) {

            if (graph.get(i).size() == 1)
                leaf++;
        }

        double answer = (double) W / leaf;

        System.out.println(answer);
    }
}