import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> leftStack = new Stack<>(); // 담아두는 용도
        Stack<String> rightStack = new Stack<>(); // 출력 용도
        String str = br.readLine();

        for (int i=0; i<str.length(); i++){
            leftStack.add(String.valueOf(str.charAt(i)));
        }

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            // new StringTokenizer(문자열, 구분자, true/false); -> true: 구분자도 토큰으로 포함 / false : 구분자는 미포함 (default)
            StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

            String s1 = st.nextToken();
            if (s1.equals("P")){
                String s2 = st.nextToken();

                leftStack.add(s2);
            }
            if (s1.equals("L") && !leftStack.isEmpty())
                rightStack.push(leftStack.pop());
            if (s1.equals("D") && !rightStack.isEmpty())
                leftStack.push(rightStack.pop());
            if (s1.equals("B") && !leftStack.isEmpty())
                leftStack.pop();
        }

        StringBuilder sb = new StringBuilder();

        while (!leftStack.isEmpty())
            rightStack.push(leftStack.pop());

        while (!rightStack.isEmpty())
            sb.append(rightStack.pop());

        System.out.println(sb.toString());
    }
}
