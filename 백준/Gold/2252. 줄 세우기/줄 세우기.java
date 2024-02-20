import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 결과 : 정답입니다!!
 * 메모리 : 49028KB
 * 시간 : 596ms
 *
 * 접근 방법
 * -- 수업 때 배웠던 위상 정렬을 그대로 적용하였습니다.
 * -- 첫 번째 주어지는 숫자는 반드시 앞에, 뒤에 주어지는 숫자는 앞선 숫자보다 더 뒤에 세워져야 합니다.
 * -- 이러한 조건을 바탕으로 앞에 주어진 숫자가 뒤에 주어지는 숫자를 가리키는 그래프를 생각하였습니다.
 * -- 노드를 연결시키는 모습을 이차원 ArrayList로 구현하였고, 위상 정렬을 진행하였습니다.
 *
 * @author 박진우
 */
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
            edge[b]++;
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