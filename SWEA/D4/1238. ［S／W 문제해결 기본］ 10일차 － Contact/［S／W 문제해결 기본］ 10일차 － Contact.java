import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case=1; test_case<=10; test_case++) {

            graph = new ArrayList<>();

            for (int i=0; i<=100; i++)
                graph.add(new ArrayList<>());

            visited = new boolean[101];
            answer = -1;

            st = new StringTokenizer(br.readLine());

            int len = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<len/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
            }

            bfs(startNode);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }



    private static void bfs(int start){

        Queue<Integer[]> queue = new LinkedList<>();

        int maxDepth = -1;

        visited[start] = true;
        queue.add(new Integer[]{start, 0});

        while(!queue.isEmpty()){

            Integer[] poll = queue.poll();

            Integer node = poll[0];
            Integer depth = poll[1];

            boolean flag = true;
            for (int nextNode : graph.get(node))
                if (!visited[nextNode]) flag = false;

            if (flag){

                if (maxDepth < depth) {
                    maxDepth = depth;
                    answer = node;
                }
                else if (maxDepth == depth)
                    answer = Math.max(answer, node);
            }

            for (int nextNode : graph.get(node)){
                if (!visited[nextNode]){
                    visited[nextNode] = true;
                    queue.add(new Integer[]{nextNode, depth+1});
                }
            }
        }
    }
}
