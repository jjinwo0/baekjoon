import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            int N = Integer.parseInt(br.readLine());

            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            // LIS를 저장할 배열
            int[] lis = new int[N];
            // LIS의 길이를 저장할 변수
            int length = 0;

            for (int i = 0; i < N; i++) {
                // 이진 탐색을 사용하여 arr[i]가 들어갈 위치를 찾습니다.
                int pos = Arrays.binarySearch(lis, 0, length, arr[i]);
                
                // 찾은 위치가 음수라면, arr[i]가 들어갈 위치가 없음을 의미합니다.
                // 이 경우, -(삽입 포인트) - 1을 해서 삽입 포인트를 얻습니다.
                if (pos < 0) pos = -(pos + 1);
                
                // arr[i]를 적절한 위치에 삽입합니다.
                lis[pos] = arr[i];
                
                // 삽입 위치가 LIS의 끝이라면, LIS의 길이를 증가시킵니다.
                if (pos == length) length++;
            }

            sb.append(length).append("\n");
        }

        System.out.println(sb);
    }
}