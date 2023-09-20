import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> crane = new ArrayList<>();
        ArrayList<Integer> box = new ArrayList<>();
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if (crane.get(0) < box.get(0)){
            System.out.println(-1);
            return;
        }

        while (!box.isEmpty()){
            int craneIdx = 0;
            int boxIdx = 0;

            while(craneIdx < N){
                if (boxIdx == box.size())
                    break;

                if (crane.get(craneIdx) >= box.get(boxIdx)) {
                    box.remove(boxIdx);
                    craneIdx++;
                }
                else boxIdx++;
            }

            answer++;
        }

        System.out.println(answer);
    }
}
