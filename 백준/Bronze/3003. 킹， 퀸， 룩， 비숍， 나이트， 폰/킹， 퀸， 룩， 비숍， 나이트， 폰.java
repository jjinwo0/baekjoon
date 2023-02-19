import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int king = sc.nextInt();
        int queen = sc.nextInt();
        int look = sc.nextInt();
        int bishop = sc.nextInt();
        int knight = sc.nextInt();
        int pawn = sc.nextInt();
        System.out.println(1-king);
        System.out.println(1-queen);
        System.out.println(2-look);
        System.out.println(2-bishop);
        System.out.println(2-knight);
        System.out.println(8-pawn);
    }
}
