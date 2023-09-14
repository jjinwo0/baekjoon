import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int index = 1;

        for (int i=2; i<=9; i++){
            int temp = sc.nextInt();
            
            if (temp > max){
                max = temp;
                index = i;
            }
        }
        
        System.out.println(max);
        System.out.println(index);
    }
}
