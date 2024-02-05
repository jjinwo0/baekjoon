import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case<=10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            LinkedList<String> list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(st.nextToken());
            }

            int K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                if (st.nextToken().equals("I")) {

                    int index = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());

                    for (int i = 0; i < count; i++) {

                        if (i + index >= N) {
                            st.nextToken();
                            continue;
                        }

                        list.add(i + index, st.nextToken());
                    }
                }
            }

            System.out.print("#" + test_case + " ");
            for (int i=0; i<10; i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
