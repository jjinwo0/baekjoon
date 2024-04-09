import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Jewelry implements Comparable<Jewelry>{

        int weight;
        int value;

        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewelry o) {
            if (this.weight == o.weight)
                return Integer.compare(o.value, this.value);

            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> pq = new PriorityQueue<>();

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            pq.offer(new Jewelry(M, V));
        }

        PriorityQueue<Integer> bag = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for (int i=0; i<K; i++){
            bag.offer(Integer.parseInt(br.readLine()));
        }

        long answer = 0;

        PriorityQueue<Jewelry> calc = new PriorityQueue<>(new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                return o2.value - o1.value;
            }
        });

        while(!bag.isEmpty()){
            Integer curBag = bag.poll();

            while(!pq.isEmpty() && curBag >= pq.peek().weight)
                calc.offer(pq.poll());

            if (!calc.isEmpty())
                answer += calc.poll().value;
        }

        System.out.println(answer);
    }
}