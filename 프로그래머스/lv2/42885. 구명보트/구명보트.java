import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int temp = 0;
        
        Arrays.sort(people);
        
        for(int i=people.length-1; i>=temp; i--){
            if(people[i] + people[temp] <= limit){
                temp++;
                answer++;
            }else
                answer++;
        }
        
        return answer;
    }
}