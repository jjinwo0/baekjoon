import java.util.*;

class Solution {
    public static String solution(String s, String skip, int index){
        String answer = "";
        List<Character> list = new ArrayList<>();

        for (int i=0; i<='z'-'a'; i++){
            list.add((char)('a'+i));
        }

        for (int i=0; i<skip.length(); i++){
            list.remove(list.indexOf(skip.charAt(i)));
        }

        for (int i=0; i<s.length(); i++){
            int idx = (list.indexOf(s.charAt(i)) + index) % list.size();

            answer += list.get(idx);
        }

        return answer;
    }
}