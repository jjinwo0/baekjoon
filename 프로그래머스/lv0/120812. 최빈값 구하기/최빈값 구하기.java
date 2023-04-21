class Solution {
    public int solution(int[] array) {
        int answer = array[0];
        int max = 0; 
        int arr[] = new int[1000];
        
        for(int i = 0; i < array.length; i++) {
            arr[array[i]]++;
            
            if(max < arr[array[i]]) {
                max = arr[array[i]];
                answer = array[i];
            }
        }
        
        int temp = 0;
        for(int j = 0; j < 1000; j++) {
            if(max == arr[j]) 
                temp++;
            if(temp > 1) 
                answer = -1;
        }
        
        return answer;
    }
}