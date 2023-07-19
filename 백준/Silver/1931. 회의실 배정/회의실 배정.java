import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] time = new int[N][2]; // [0] : 회의 시작, [1] : 회의 종료

        for (int i=0; i<N; i++){
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) // 종료 시간이 같다면,
                    return o1[0] - o2[0]; // 시작 시간으로 내림차순

                return o1[1] - o2[1]; // 종료 시간으로 내림차순
            }
        });

        int cnt = 0;
        int lastEndTime = 0;

        for (int i=0; i<N; i++){
            if (lastEndTime <= time[i][0]) { // 시작 시간이 직전 종료 시간보다 크거나 같다면,
                lastEndTime = time[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
