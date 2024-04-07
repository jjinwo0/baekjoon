import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int answer;
    static ArrayList<Character> operatorList;
    static ArrayList<Integer> numList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        operatorList = new ArrayList<>();
        numList = new ArrayList<>();

        for (int i=0; i<N; i++){

            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*')
                operatorList.add(input.charAt(i));

            else numList.add(Character.getNumericValue(input.charAt(i)));
        }

        answer = Integer.MIN_VALUE;

        dfs(numList.get(0), 0);

        sb.append(answer);

        System.out.println(sb);
    }

    private static void dfs(Integer value, int depth) {

        if (depth >= operatorList.size()){
            answer = Math.max(answer, value);
            return;
        }

        int temp = calculate(value, operatorList.get(depth), numList.get(depth + 1));
        dfs(temp, depth + 1);

        if (depth + 1 < operatorList.size()){

            int temp2 = calculate(numList.get(depth + 1), operatorList.get(depth + 1), numList.get(depth + 2));
            temp2 = calculate(value, operatorList.get(depth), temp2);

            dfs(temp2, depth + 2);
        }
    }

    private static int calculate(Integer value1, Character op, Integer value2) {

        if (op == '+')
            return value1 + value2;

        if (op == '-')
            return value1 - value2;

        if (op == '*')
            return value1 * value2;

        return 0;
    }
}