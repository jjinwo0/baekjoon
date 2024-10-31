import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []list=new int[n];
        int []dp=new int[n]; 
        for(int i=0;i<n;i++){
            list[i]=sc.nextInt();
        }

        dp[0]=list[0];

        for(int i=1;i<n;i++){
            dp[i]=list[i];
            for(int j=0;j<i;j++){
                  if(list[i]>list[j] && dp[j]+list[i]>dp[i])
                      dp[i]=dp[j]+list[i];
                }
            }

        int max=0;
        for(int i=0;i<n;i++){
            if(max<dp[i])
                max=dp[i];
        }

        System.out.print(max);


    }
}