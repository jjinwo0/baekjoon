import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[sc.nextInt()];
        double sum = 0;
        double max = 0;

        for (int i=0; i<arr.length; i++){
            arr[i] = sc.nextDouble();
            if (arr[i] > max)
                max = arr[i];
        }
        for (int i=0; i<arr.length; i++){
            sum += (arr[i] / max) * 100;
        }

        System.out.println(sum / arr.length);
    }
}
