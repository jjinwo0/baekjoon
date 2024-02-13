import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        if(check()) {
            for (int i=0; i<num.length; i++){
                System.out.print(num[i] +  " ");
            }
        }

        else System.out.println(-1);
    }

    private static boolean check() {

        int temp = num.length - 1;

        while(temp > 0 && num[temp-1] >= num[temp])
            temp--;

        if (temp <= 0)
            return false;

        int temp2 = num.length - 1;

        while(num[temp-1] >= num[temp2])
            temp2--;

        if (temp2 <= 0)
            return false;

        swap(temp-1, temp2);

        int len = num.length-1;

        while(len > temp){
            swap(temp, len);
            len-=1;
            temp+=1;
        }

        return true;
    }

    private static void swap(int i, int j) {

        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}