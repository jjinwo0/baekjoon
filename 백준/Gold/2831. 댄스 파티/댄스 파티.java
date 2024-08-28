import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> higherMen = new PriorityQueue<>();
        PriorityQueue<Integer> lowerMen = new PriorityQueue<>();
        PriorityQueue<Integer> higherWomen = new PriorityQueue<>();
        PriorityQueue<Integer> lowerWomen = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){

            int input = Integer.parseInt(st.nextToken());

            if (input < 0)
                lowerMen.add(-input); // 작은 남자의 키를 양수로 변환하여 큐에 삽입
            else
                higherMen.add(input); // 큰 남자의 키를 큐에 삽입
        }

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){

            int input = Integer.parseInt(st.nextToken());

            if (input < 0)
                lowerWomen.add(-input); // 작은 여자의 키를 양수로 변환하여 큐에 삽입
            else
                higherWomen.add(input); // 큰 여자의 키를 큐에 삽입
        }

        int answer = 0;

        // 작은 남자와 큰 여자의 키 비교
        while (!lowerMen.isEmpty() && !higherWomen.isEmpty()) {

            int curMan = lowerMen.poll();    // 현재 작은 남자의 키
            int curWoman = higherWomen.peek(); // 현재 큰 여자의 키

            if (curMan > curWoman) { // 작은 남자가 큰 여자보다 키가 크면 매칭
                answer++;
                higherWomen.poll();  // 매칭된 여자 큐에서 제거
            }
        }

        // 작은 여자와 큰 남자의 키 비교
        while (!lowerWomen.isEmpty() && !higherMen.isEmpty()) {

            int curWoman = lowerWomen.poll();  // 현재 작은 여자의 키
            int curMan = higherMen.peek();     // 현재 큰 남자의 키

            if (curWoman > curMan) { // 작은 여자가 큰 남자보다 키가 크면 매칭
                answer++;   // 매칭된 여자 큐에서 제거
                higherMen.poll();    // 매칭된 남자 큐에서 제거
            }
        }

        System.out.println(answer); // 결과 출력
    }
}