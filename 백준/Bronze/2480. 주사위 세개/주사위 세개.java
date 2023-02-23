import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] dice = new int[3];

        for (int i=0; i<3; i++){
            dice[i] = sc.nextInt();
        }
        if (dice[0] == dice[1]){
            if (dice[0] == dice[2]) //모든 숫자가 같은 숫자일 때
                System.out.println(10000+dice[0]*1000);
            else System.out.println(1000 + dice[0] * 100); //0과 1만 같을 때
        }
        else if(dice[1] == dice[2]){ //1과 2만 같을 때
            System.out.println(1000 + dice[1] * 100);
        }
        else if (dice[0] == dice[2]) //0과 2만 같을 때
            System.out.println(1000 + dice[0] * 100);
        else {
            Arrays.sort(dice);
            System.out.println(dice[2]*100);
        }
    }
}