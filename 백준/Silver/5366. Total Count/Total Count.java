import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        while(true){

            String input = br.readLine();

            if (input.equals("0"))
                break;

            map.put(input, map.getOrDefault(input, 0)+1);
        }

        int sum = 0;

        for (Map.Entry<String, Integer> entry :map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            sum += entry.getValue();
        }

        System.out.println("Grand Total: " + sum);
    }
}
