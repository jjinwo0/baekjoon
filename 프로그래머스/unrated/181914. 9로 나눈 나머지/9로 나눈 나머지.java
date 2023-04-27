class Solution {
    public int solution(String number){
        int answer = 0;
        int temp = 0;
        for (int i=1; i<=number.length(); i++){
            temp += Integer.parseInt(number.substring(i-1, i));
        }
        answer = temp % 9;
        
        return answer;
    }
}