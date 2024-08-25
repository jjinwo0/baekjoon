import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static Integer N, M;

    static int[] arr, parents;

    static boolean[] knewArr;

    static ArrayList<ArrayList<Integer>> participants;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        arr = new int[size];

        for (int i=0; i<size; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        participants = new ArrayList<>();

        for (int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());

            participants.add(new ArrayList<>());

            int num = Integer.parseInt(st.nextToken());

            for (int k=0; k<num; k++) {

                participants.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        knewArr = new boolean[N + 1];
        parents = new int[N + 1];

        for (int tr : arr)
            knewArr[tr] = true;

        for (int i=0; i<=N; i++)
            parents[i] = i;

        for (int i=0; i<M; i++) {

            for (int j=0; j<participants.get(i).size()-1; j++) {

                union(participants.get(i).get(j), participants.get(i).get(j + 1));
            }
        }

        for (int i=1; i<=N; i++) {

            if (knewArr[i]){
                int p = find(i);
                knewArr[p] = true;
            }
        }

        int answer = 0;

        for (int i=0; i<M; i++) {

            boolean flag = true;

            for (int j=0; j<participants.get(i).size(); j++) {

                int p = participants.get(i).get(j);
                int parent = find(p);
                
                if (knewArr[parent]){
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
        }

        System.out.println(answer);
    }

    public static void union(int n, int m) {

        n = find(n);
        m = find(m);

        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }

        if (n == m) return;
        else parents[m] = n;
    }

    private static int find(int n) {

        if (parents[n] == n)
            return n;

        return parents[n] = find(parents[n]);
    }
}