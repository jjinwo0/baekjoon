import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[] solution(int n, String[] words){
        int[] answer = {0,0};
        List<String> list = new ArrayList<>(Arrays.asList(words));

        Loop1:
        for (int i=1; i<words.length; i++){
            Loop2:
            for (int j=0; j<i; j++){
                if (words[i].equals(words[j])){
                    answer[0] = (i%n) + 1;
                    answer[1] = (i/n) + 1;
                    break Loop1;
                }
            }
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                break;
            }
        }

        return answer;
    }
}
