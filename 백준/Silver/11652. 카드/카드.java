import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Long, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            Long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = 0;
        ArrayList<Integer> list = new ArrayList<>(map.values());

        for(int i : list){
            if (max < i)
                max = i;
        }
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(Long key : map.keySet()){
            if(max == map.get(key)){
                q.add(key);
            }
        }
        System.out.println(q.poll());
    }
}
