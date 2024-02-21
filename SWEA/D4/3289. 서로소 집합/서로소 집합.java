import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, m;

    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++){

            sb.append("#" + test_case + " ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            graph = new int[n+1];

            for (int i=0; i<n; i++){
                graph[i] = i;
            }

            for (int i=0; i<m; i++){

                st = new StringTokenizer(br.readLine());

                int input = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (input == 0)
                    union(a, b);

                if (input == 1) {
                    int findA = find(a);
                    int findB = find(b);

                    if (findA == findB)
                        sb.append(1);

                    else sb.append(0);
                }
            }

            sb.append("\n");

        }

        System.out.println(sb);
    }

    private static int find(int node) {

        if (node == graph[node])
            return node;

        graph[node] = find(graph[node]);

        return graph[node];
    }

    private static void union(int a, int b) {

        int findA = find(a);
        int findB = find(b);

        if (findA <= findB)
            graph[findB] = findA;

        else graph[findA] = findB;
    }
}