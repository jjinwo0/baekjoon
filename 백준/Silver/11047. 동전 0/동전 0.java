import java.util.Scanner;

public class Main {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int total = sc.nextInt();
        int[] arr = new int[N];
        int flag = -1;

        for (int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            if (arr[i] > total)
                flag = i-1;
        }

        if (flag == -1){
            calc(N-1, total, arr);
        }else {
            calc(flag, total, arr);
        }

        System.out.println(answer);
    }

    public static void calc(int N, int total, int[] arr){
        for (int i=N; i>=0; i--){
            int temp = total / arr[i];
            if (temp > 0){
                answer += temp;
                total = total - arr[i] * temp;
            }
        }
    }
}
