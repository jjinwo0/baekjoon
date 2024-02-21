import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int L, C;
    static char[] type;
    static char[] code;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        code = new char[L];
        type = new char[C];

        type = br.readLine().replace(" ", "").toCharArray();

        Arrays.sort(type);

        choose(0, 0);

        System.out.println(sb);
    }

    private static void choose(int n, int index) {

        if (index == L){
            if (checkCode()){
                for (char c : code)
                    sb.append(c);
                sb.append("\n");
            }

            return;
        }

        for (int i=n; i<C; i++){
            code[index] = type[i];
            choose(i+1, index+1);
        }
    }

    private static boolean checkCode() {

        int m=0;
        int s=0;

        for (char c : code){
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                m++;
            else s++;
        }

        if (m >= 1 && s >= 2)
            return true;

        return false;
    }
}
