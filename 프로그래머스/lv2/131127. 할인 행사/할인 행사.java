import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<10; i++){
            // 10일까지의 할인 품목 수량 담기
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        // want 품목이 담겨있는지, 정확한 수량인지 확인하는 메서드
        if(compareWants(map, want, number)) answer++;
        
        // 10일 내에 모든 물품이 있어야 하므로, 10일 단위로 끊고 반복
        for(int i=0; i<discount.length-10; i++){
            map.replace(discount[i], map.get(discount[i])-1);
            map.put(discount[i+10], map.getOrDefault(discount[i+10], 0)+1);
            
            if(compareWants(map, want, number)) answer++;
        }
        
        return answer;
    }
    
    public boolean compareWants(HashMap<String, Integer> map, String[] want, int[] number){
        
        for(int i=0; i<want.length; i++){
            // 해당 물품이 map에 없거나 map에 담긴 value와 실제 수량이 다른 경우, false 반환
            if(!map.containsKey(want[i]) || map.get(want[i]) != number[i])
                return false;
        }
        
        return true;
    }
}