import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i=0; i<T; i++){
            int N = sc.nextInt();
            int answer = 1;
            int[] test = new int[N+1];

            for (int k=0; k<N; k++){
                int a = sc.nextInt();
                int b = sc.nextInt();

                test[a] = b; // 서류 점수를 index 값으로, 면접 점수를 value 값으로
            }

            int temp = test[1]; // 서류 점수 1등이 기준

            for (int k=2; k<=N; k++){
                if (test[k] < temp){
                    answer++;
                    temp = test[k];
                }
            }

            System.out.println(answer);
        }
        sc.close();
    }
}
