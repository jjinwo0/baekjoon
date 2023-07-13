import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] rope = new int[N];
        int answer = 0;

        for (int i=0; i<N; i++){
            rope[i] = sc.nextInt();
        }
        Arrays.sort(rope);

        for (int i=0; i<N; i++){
            int temp = rope[N - 1 - i] * (i + 1);
            if (answer < temp)
                answer = temp;
        }
        
        System.out.println(answer);
    }
}
