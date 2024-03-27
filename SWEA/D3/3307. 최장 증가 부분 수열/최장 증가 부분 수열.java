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

            // LIS를 구하기 위한 DP 배열
            int[] dp = new int[N];

            // DP 배열의 모든 위치를 1로 초기화합니다. 
            // (최소한 각 수 자체로 이루어진 부분 수열의 길이는 1이기 때문입니다.)
            Arrays.fill(dp, 1);

            // LIS 구하기
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            // DP 배열에서 최댓값 찾기
            int max = Arrays.stream(dp).max().getAsInt();

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}