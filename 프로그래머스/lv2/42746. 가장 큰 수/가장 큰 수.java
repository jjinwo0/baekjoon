import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        String answer = "";
        
        
        for(int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        StringBuilder sb = new StringBuilder();
        
        for(String str : arr){
            sb.append(str);
        }
        
        answer = sb.toString();
        
        if(answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}