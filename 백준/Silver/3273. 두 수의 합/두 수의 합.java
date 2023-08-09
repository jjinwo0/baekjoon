import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        int x = Integer.parseInt(br.readLine());

        Collections.sort(list);

        int left = 0;
        int right = n-1;

        while(left<right){
            int sum = list.get(left) + list.get(right);

            if(sum == x){
                answer++;
                left++;
                right--;
            }
            else if(sum < x) left++;
            else right--;
        }

        System.out.println(answer);
    }
}
