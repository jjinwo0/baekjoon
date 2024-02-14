import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int temp = N-1;

        while(temp > 0 && num[temp] >= num[temp-1])
            temp--;

        if (temp <= 0){
            sb.append(-1);
            System.out.println(sb);
            return;
        }

        int temp2 = N-1;

        while(num[temp2] >= num[temp-1])
            temp2--;

        swap(temp-1, temp2);

        int len = N-1;

        while(len > temp){
            swap(len--, temp++);
        }

        for (int i=0; i<N; i++){
            sb.append(num[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void swap(int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}