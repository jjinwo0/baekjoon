import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(findChar(Arrays.asList(br.readLine().split(""))));

    }

    public static String findChar(List<String> str) {
        Map<String, Integer> map = new HashMap<>();
        String maxString = "";
        int maxValue = 0;
        int cnt = 0;

        for (String s : str) {
            String upper = s.toUpperCase();
            map.put(upper, map.getOrDefault(upper, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            if (maxValue == m.getValue())
                cnt++;

            if (maxValue < m.getValue()) {
                maxString = m.getKey();
                maxValue = m.getValue();
                cnt = 1;
            }
        }

        if (cnt > 1)
            return "?";

        return maxString;
    }
}
