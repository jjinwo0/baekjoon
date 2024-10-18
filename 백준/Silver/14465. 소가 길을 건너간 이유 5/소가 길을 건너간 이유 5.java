import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int []arr= new int[100005];
    public static void main(String[] args) throws IOException {
       int n,k,b;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        for(int i=0;i<b;i++)
        {
            int a = Integer.parseInt(br.readLine());
            arr[a] = 1;
        }
        int cnt =0;
        for(int i=1;i<=k;i++)
        {
            if(arr[i] ==1)
                cnt++;
        }
        int m = cnt;
        for(int l=1;l+k-1<n;l++)
        {
            if(arr[l]== 1)
                cnt--;
            if(arr[l+k] == 1)
                cnt++;
            m = Math.min(m,cnt);
        }
        bw.write(Integer.toString(m));
        bw.flush();
    }
}