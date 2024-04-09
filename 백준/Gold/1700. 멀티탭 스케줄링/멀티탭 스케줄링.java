import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] schedule = new int[K + 1];
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i=0; i<input.length; i++){
            schedule[input[i]] += 1;
        }

        HashSet<Integer> multi = new HashSet<>();

        for (int i=0; i<K; i++){
            int next = input[i];

            if (multi.contains(next)){
                schedule[next]--;
                continue;
            }

            if (multi.size() < N){
                multi.add(next);
                schedule[next]--;
                continue;
            }
            int maxIndex = -1;
            int removeConsent = 0;

            Iterator<Integer> iterator = multi.iterator();

            while (iterator.hasNext()) {
                int consent = iterator.next();
                int lastIndex = Integer.MAX_VALUE;

                for (int j = i + 1; j < K; j++) {
                    if (input[j] == consent) {
                        lastIndex = j;
                        break;
                    }
                }

                if (lastIndex > maxIndex) {
                    maxIndex = lastIndex;
                    removeConsent = consent;
                }
            }

            multi.remove(removeConsent);
            multi.add(next);
            count++;
        }

        System.out.println(count);
    }
}