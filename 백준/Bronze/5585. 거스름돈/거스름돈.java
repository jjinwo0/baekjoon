import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 1000 - sc.nextInt();
        int count = 0;

        while (true){
            if (money / 500 > 0){
                count += money / 500;
                money %= 500;
            }
            else if (money / 100 > 0){
                count += money / 100;
                money %= 100;
            }
            else if (money / 50 > 0){
                count += money / 50;
                money %= 50;
            }
            else if (money / 10 > 0){
                count += money / 10;
                money %= 10;
            }
            else if (money / 5 > 0){
                count += money / 5;
                money %= 5;
            }
            else if (money / 1 > 0){
                count += money / 1;
                money %= 1;
            }
            if (money <= 0)
                break;
        }

        System.out.println(count);
    }
}
