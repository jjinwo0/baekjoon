import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> map;
    static int[] value;
    static boolean[] selected;
    static int answer, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        value = new int[N + 1];
        answer = Integer.MAX_VALUE;
        selected = new boolean[N + 1];

        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++){
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            for (int k=1; k<=n; k++){
                map.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        check(1);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(answer);
    }

    private static void check(int index) {
        if (index == N + 1) {
            ArrayList<Integer> teamA = new ArrayList<>();
            ArrayList<Integer> teamB = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                if (selected[i]) teamA.add(i);
                else teamB.add(i);
            }

            // At least one team should have members
            if (teamA.isEmpty() || teamB.isEmpty())
                return;

            if (vote(teamA) && vote(teamB)) {
                calc(teamA, teamB);
            }

            return;
        }

        selected[index] = true;
        check(index + 1);
        selected[index] = false;
        check(index + 1);
    }

    private static boolean vote(ArrayList<Integer> team) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.offer(team.get(0));
        visited[team.get(0)] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int nextNode : map.get(poll)) {
                if (team.contains(nextNode) && !visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }

        for (int member : team) {
            if (!visited[member]) {
                return false;
            }
        }

        return true;
    }

    private static void calc(ArrayList<Integer> teamA, ArrayList<Integer> teamB) {
        int sumA = 0, sumB = 0;

        for (int member : teamA) {
            sumA += value[member];
        }

        for (int member : teamB) {
            sumB += value[member];
        }

        answer = Math.min(answer, Math.abs(sumA - sumB));
    }
}