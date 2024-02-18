import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] burger = new long[51];
    static long[] patty = new long[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        burger[0] = 1;
        patty[0] = 1;

        for (int i=1; i<=N; i++){
            burger[i] = burger[i-1] * 2 + 3;
            patty[i] = patty[i-1] * 2 + 1;
        }

        System.out.println(countingPatty(N, X));
    }

    private static long countingPatty(int N, long X) {
        if (N == 0){
            if (X == 1)
                return 1;
            return 0;
        }

        if (X == 1)
            return 0;

        // 먹는 양이 현재 버거 크기와 같다면,
        if (X == burger[N])
            return patty[N]; // 현재 패티 갯수 return

        // 먹는 양이 이전 버거 + 패티 + 빵의 길이와 같다면,
        if (X == burger[N-1]+2)
            return patty[N-1] + 1; // 이전 패티 + 껴있는 패티 갯수(1) return

        // 이전 버거 값 + 패티 + 빵 길이보다 작다면,
        if (X < burger[N-1]+2){
            return countingPatty(N - 1, X - 1); // 추가되는 빵 1개를 빼주어 재귀
        }

        // 이전 버거 값 + 패티 + 빵 길이보다 크다면,
        if (X > burger[N-1]+2){
            return patty[N - 1] + 1 + countingPatty(N - 1, X - burger[N-1] - 2); // 이전 패티 + 껴있는 패티(1) + 작은 범위 재귀
        }

        return 0;
    }
}
