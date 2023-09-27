import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Class{
        int start;
        int end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Class[] classes = new Class[N];

        for (int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            classes[i] = new Class(start, end);
        }

        // 시작 시간 기준 오름차순
        // 시작 시간이 같다면, 종료 시간 기준 오름차
        Arrays.sort(classes, ((o1, o2) ->
                o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(classes[0].end);

        for (int i=1; i<N; i++){

            // 우선순위에서 가장 작은 종료 시간과 classes 배열의 시작 시간 비교
            if (classes[i].start >= queue.peek()) // 가장 작은 종료 시간이 수업 시작 시간보다 작거나 같다면,
                queue.poll(); // 가장 작은 종료시간 제거

            queue.offer(classes[i].end);
        }

        System.out.println(queue.size());
    }
}
