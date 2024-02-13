import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case=1; test_case<=T; test_case++){

            ArrayList<Integer> gyu = new ArrayList<>();
            ArrayList<Integer> in = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<9; i++){
                gyu.add(Integer.parseInt(st.nextToken()));
            }

            for (int i=1; i<19; i++){
                if (gyu.contains(i))
                    continue;

                in.add(i);
            }

            gyu.sort(((o1, o2) -> o1 - o2));

            int winCount = 0;
            int loseCount = 0;

            do {
                int winScore = 0;
                int loseScore = 0;

                for (int i=0; i<gyu.size(); i++){
                    if (gyu.get(i) > in.get(i))
                        winScore += gyu.get(i) + in.get(i);

                    else loseScore += gyu.get(i) + in.get(i);
                }

                if (winScore > loseScore)
                    winCount+=1;

                if(loseScore > winScore)
                    loseCount+=1;

            }while(nextPermutation(gyu));

            sb
                    .append("#")
                    .append(test_case)
                    .append(" ").append(winCount)
                    .append(" ").append(loseCount)
                    .append("\n");
        }
        System.out.println(sb);
    }

    private static boolean nextPermutation(ArrayList<Integer> list) {

        int i = list.size()-1;

        while(i > 0 && list.get(i) < list.get(i-1))
            i--;

        if (i <= 0)
            return false;

        int j = list.size()-1;

        while(list.get(j) < list.get(i-1))
            j--;

        swap(list, i-1, j);

        int size = list.size()-1;

        while(i < size){
            swap(list, i, size);
            i++;
            size--;
        }

        return true;
    }

    private static void swap(ArrayList<Integer> list, int i, int j) {

        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

}