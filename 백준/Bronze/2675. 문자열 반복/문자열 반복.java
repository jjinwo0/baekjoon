import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=0; i<n; i++){
            int re = sc.nextInt();
            String str = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int j=1; j<=str.length(); j++){
                for (int k=0; k<re; k++)
                    sb.append(str.substring(j-1, j));
            }
            System.out.println(String.valueOf(sb));
        }
    }
}