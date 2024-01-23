import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] preorder, inorder;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());

            preorder = new int[N];
            inorder = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n=0; n<N; n++){
                preorder[n] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int n=0; n<N; n++){
                inorder[n] = Integer.parseInt(st.nextToken());
            }

            postorder(0, N-1, 0, N-1);
            System.out.println();
        }
    }

    private static void postorder(int preStart, int preEnd, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd)
            return;

        int rootIndex = 0;

        for (int i=inStart; i<=inEnd; i++){

            if (inorder[i] == preorder[preStart]) {
                rootIndex = i;
                break;
            }
        }

        postorder(preStart+1, preStart+rootIndex-inStart, inStart, rootIndex-1);

        postorder(preStart+rootIndex+1-inStart, preEnd, rootIndex+1, inEnd);

        System.out.print(inorder[rootIndex]+" ");
    }
}