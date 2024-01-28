import java.util.Scanner;

public class Main {

    static int N, count;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];

        nQueen(0);

        System.out.println(count);
    }

    private static void nQueen(int depth) {

        if (depth == N){
            count++;
            return;
        }

        for (int i=0; i<N; i++){
            arr[depth] = i;

            if (check(depth))
                nQueen(depth + 1);
        }
    }

    private static boolean check(int depth) {

        for (int i=0; i<depth; i++){

            if (arr[i] == arr[depth])
                return false;

            if (Math.abs(arr[depth] - arr[i]) == Math.abs(depth - i))
                return false;
        }

        return true;
    }
}
