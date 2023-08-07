import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i=0; i<truck_weights.length; i++){
            int truck = truck_weights[i];
            
            while(true){
                if(bridge.isEmpty()){
                    bridge.add(truck);
                    sum += truck;
                    answer++;
                    break;
                } else if (bridge.size() == bridge_length){
                    sum -= bridge.poll();
                } else {
                    if(sum + truck <= weight){
                        bridge.add(truck);
                        sum += truck;
                        answer++;
                        break;
                    } else {
                        bridge.add(0);
                        answer++;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}