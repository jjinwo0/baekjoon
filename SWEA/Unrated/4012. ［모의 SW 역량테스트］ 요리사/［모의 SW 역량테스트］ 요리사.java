import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] food;
    static boolean[] check;
    static int N, min;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test_case=1; test_case<=T; test_case++) {
            min=Integer.MAX_VALUE;

            N= Integer.parseInt(br.readLine());

            food = new int[N][N];
            check = new boolean[N];

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++) {
                    food[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("#"+test_case+" ");
            comb(0,0);
            sb.append(min+"\n");
        }
        System.out.println(sb.toString());
    }

    public static void comb(int cnt, int start) {
        if(cnt==N/2) {
            check();
            return;
        }

        for(int i=start; i<N;i++) {
            check[i] = true;
            comb(cnt+1,i+1);
            check[i] = false;
        }
    }

    public static void check() {
        int A=0, B=0, result=0;

        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                if(check[i] && check[j]) {
                    A+=food[i][j]+food[j][i];
                }
                else if(!check[i] && !check[j]) {
                    B+=food[i][j]+food[j][i];
                }
            }
        }
        result = Math.abs(A-B);
        min = Math.min(result, min);
    }
}