import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        for (int i=0; i<N; i++){
            int temp = sc.nextInt();
            int flag = 0;
            if (temp == 1)
                continue;
            else if (temp == 2 || temp == 3)
                answer++;
            else{
                for (int j=2; j<temp; j++){
                    if (temp % j == 0){
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                    answer++;
            }
        }
        System.out.println(answer);
    }
}
