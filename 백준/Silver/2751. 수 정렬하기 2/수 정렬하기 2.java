import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        for (Integer temp : list){
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }
}