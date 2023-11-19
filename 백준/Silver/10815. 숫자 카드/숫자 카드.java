import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{


    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());

        Arrays.sort(arr);
        for (int i = 0; i < M; i++) {
            int find = Integer.parseInt(st.nextToken());

            if (result(find,N)) System.out.print(1+" ");
            else System.out.print(0+" ");

        }
    }

    static boolean result(int find,int N){
        int left = 0;
        int right = N-1;

        while(left <= right){

            int midIndex = (right+left)/2;
            int mid = arr[midIndex];

            if(mid < find){
                left = midIndex+1;
            }else if(mid > find){
                right = midIndex-1;
            }else if(find == mid){
                return true;
            }
        }
        return false;
    }
}