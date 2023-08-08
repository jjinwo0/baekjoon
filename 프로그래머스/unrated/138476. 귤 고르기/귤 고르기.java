import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        
        keyList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1))); // 내림차순
        
        for(int n : keyList){
            k -= map.get(n);
            answer++;
            
            if(k <= 0)
                break;
        }
            
        return answer;
    }
}