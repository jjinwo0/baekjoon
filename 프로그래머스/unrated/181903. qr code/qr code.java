class Solution {
    public String solution(int q, int r, String code){
        String answer = "";
        for (int i=r+1; i<=code.length(); i+=q){
            answer += code.substring(i-1, i);
        }

        return answer;
    }
}