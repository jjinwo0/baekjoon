import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        StringBuffer sba = new StringBuffer(a);
        StringBuffer sbb = new StringBuffer(b);

        int A = Integer.parseInt(String.valueOf(sba.reverse()));
        int B = Integer.parseInt(String.valueOf(sbb.reverse()));

        if (A >= B)
            System.out.println(A);
        else System.out.println(B);
    }
}
