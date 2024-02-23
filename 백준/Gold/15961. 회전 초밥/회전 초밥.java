import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        int[] eaten = new int[d+1];

        for (int i=0; i<N; i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        for (int i=0; i<k; i++){
            if (eaten[sushi[i]]++ == 0) count++;
        }

        int max = count;

        for (int i=1; i<=N; i++){

            if(max <= count){
                // 쿠폰 초밥을 먹은 적이 있다면 +1
                if(eaten[c] == 0) max = count + 1;

                else max = count;
            }

            if (--eaten[sushi[i-1]] == 0)
                count--;

            if (eaten[sushi[(i + k - 1) % N]]++ == 0)
                count++;

        }

        System.out.println(max);
    }
}