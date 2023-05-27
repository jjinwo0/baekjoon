import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes){
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cl : clothes){
            String type = cl[1];
            //type의 값을 가져오고, 아니면 return 0
            //옷 종류별 갯수를 value로 가짐
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        Iterator<Integer> iterator = map.values().iterator();
        int answer = 1;
        
        while(iterator.hasNext()){
            answer *= iterator.next().intValue()+1;
        }

        return answer-1;
    }
}