import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String croatia = sc.next();

        for (int i=0; i<arr.length; i++){
            while(croatia.contains(arr[i])) {
                answer++;
                croatia = croatia.replaceFirst(arr[i], "1");
            }
        }
        croatia = croatia.replaceAll("1", "");
        int total = answer + croatia.length();

        System.out.println(total);
    }
}