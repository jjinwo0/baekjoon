import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] tree;
    static boolean[] check;
    static int answer, N, root;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        tree = new int[N];
        check = new boolean[N];
        answer = 0;

        for (int i=0; i<N; i++){
            tree[i] = sc.nextInt();
            if (tree[i] == -1) root = i;
        }

        int input = sc.nextInt();

        delete(input);

        countLeaf(root);

        System.out.println(answer);
    }

    private static void countLeaf(int n) {

        check[n] = true;
        boolean leaf = true;

        if (tree[n] != -2){
            for (int i=0; i<N; i++){
                if (tree[i] == n && check[i] == false){
                    countLeaf(i);
                    leaf = false;
                }
            }

            if (leaf) answer++;
        }
    }

    private static void delete(int input) {

        tree[input] = -2;

        for (int i=0; i<tree.length; i++){
            if (tree[i] == input)
                delete(i);
        }
    }
}
