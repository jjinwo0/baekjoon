import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens())
            list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        int left = 0;
        int right = N-1;
        int diff = Integer.MAX_VALUE;

        int small = 0;
        int big = 0;

        while(left < right){

            int temp = Math.abs(list.get(left) + list.get(right));

            if (temp < diff){
                diff = temp;
                small = list.get(left);
                big = list.get(right);
            }
            if (list.get(left) + list.get(right) > 0)
                right--;
            else left++;
        }

        System.out.println(small + " " + big);

    }
}
