import java.util.*;

public class Main {
    
    static int[] P;
    static Integer[] dp;
    
    public static void main (String[] arg) {
        
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = null;
        int max = 0;
        
        int N = Integer.parseInt(sc.nextLine());
        
        P = new int[N+1];
        dp = new Integer[N+1];
        
        st = new StringTokenizer(sc.nextLine(), " ");
        
        for (int i=1; i<N+1; i++) P[i] = Integer.parseInt(st.nextToken());
        
       	dp[0] = 0;
        
        System.out.println(recur(N));
        
        sc.close();
    }
    
    static int recur (int N) {
        
        if (dp[N] == null) {
        	
            dp[N] = P[N];
            
            int idx = 1;
            
            while (N - idx > 0) {
                dp[N] = Math.max(dp[N], recur(N-idx) + P[idx]);
                idx++;
            }
        }
        
        return dp[N];
    }
}