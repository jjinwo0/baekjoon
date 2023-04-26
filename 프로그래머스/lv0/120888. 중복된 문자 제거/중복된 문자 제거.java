class Solution {
    public String solution(String my_string){
        String answer = "";
        String[] arr = new String[my_string.length()];

        for (int i=0; i<my_string.length(); i++){
            if (!answer.contains(String.valueOf(my_string.charAt(i))))
                answer += String.valueOf(my_string.charAt(i));
            else
                continue;
        }
        return answer;
    }
}