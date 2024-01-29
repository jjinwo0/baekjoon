import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<String>[] arr = new ArrayList[n+3];

        for(int i = 0; i <= n+2; i++)
            arr[i] = new ArrayList<>();

        arr[1].add("1");

        arr[2].add("1+1");
        arr[2].add("2");

        arr[3].add("1+1+1");
        arr[3].add("1+2");
        arr[3].add("2+1");
        arr[3].add("3");

        for (int i=4; i<=n; i++){
            for (int j=1; j<=3; j++){
                for (int m=0; m<arr[i-j].size(); m++){

                    /**
                     * 1+1+1+1
                     * 1+2+1
                     * 2+1+1
                     * 3+1
                     *
                     * 1+1+2
                     * 2+2
                     *
                     * 1+3
                     */
                    arr[i].add(arr[i-j].get(m) + "+" + j);
                }
            }
        }

        Collections.sort(arr[n]);

        if (k > arr[n].size()){
            System.out.println(-1);
            return;
        }


        System.out.println(arr[n].get(k-1));
    }
}
