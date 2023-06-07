import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {

    public int[] solution(int[] progress, int[] speed){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<progress.length; i++){
            int temp = (100-progress[i])/speed[i];
            if ((100-progress[i])%speed[i] > 0)
                temp += 1;

            queue.add(temp);
        }

        int n = queue.poll();
        int cnt = 1;
        while(!queue.isEmpty()){
            if (n >= queue.peek()){
                cnt++;
                queue.poll();
            }else {
                list.add(cnt);
                cnt = 1;
                n = queue.poll();
            }
            if (queue.peek() == null)
                list.add(cnt);
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}