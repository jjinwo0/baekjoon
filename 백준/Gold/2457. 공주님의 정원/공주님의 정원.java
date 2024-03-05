import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Flower implements Comparable<Flower>{
        int startDay;
        int endDay;

        public Flower(int startDay, int endDay) {
            this.startDay = startDay;
            this.endDay = endDay;
        }

        @Override
        public int compareTo(Flower o) {

            if (this.startDay < o.startDay)
                return -1;

            if (this.startDay == o.startDay){
                if (this.endDay > o.endDay)
                    return -1;

                if (this.endDay == o.endDay)
                    return 0;

                return 1;
            }

            else return 1;
        }
    }

    static Flower[] flowers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        flowers = new Flower[N];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay);
        }

        Arrays.sort(flowers);

        int s=301;
        int e=1201;
        int max = 0;
        int index=0;
        int count = 0;

        while(s < e){

            boolean find = false;

            for (int i=index; i<N; i++){

                if (flowers[i].startDay > s)
                    break;

                if (max < flowers[i].endDay){
                    find = true;
                    max = flowers[i].endDay;
                    index += 1;
                }
            }

            if (find){
                s = max;
                count += 1;
            } else break;
        }

        if (max < e)
            System.out.println(0);

        else System.out.println(count);

    }
}