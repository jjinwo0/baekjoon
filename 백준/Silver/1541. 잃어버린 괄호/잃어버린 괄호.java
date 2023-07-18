import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = Integer.MAX_VALUE; // 초기값 여부 확인을 위한 초기화

        // 뺄셈으로 문자열을 split
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while(st.hasMoreTokens()){
            int temp = 0;

            // 나눠진 문자열에서 덧셈을 기준으로 문자열 다시 split
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while(st2.hasMoreTokens()){
                temp += Integer.parseInt(st2.nextToken()); // 덧셈 안의 피연산자끼리 합
            }

            if (answer == Integer.MAX_VALUE) // 만약 초기 값이라면,
                answer = temp; // 덧셈 값을 우선 담아주고
            else answer -= temp; // 덧셈을 제외한 나머지 피연산자들을 마지막까지 뺄셈
        }

        System.out.println(answer);
    }
}
