import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String[] genres, int[] plays){
        List<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> genmap = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> numberplays = new HashMap<>();

        for (int i=0; i<genres.length; i++){
            if (!genmap.containsKey(genres[i])){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                numberplays.put(genres[i], map);
                genmap.put(genres[i], plays[i]);
            }else {
                numberplays.get(genres[i]).put(i, plays[i]);
                genmap.put(genres[i], genmap.get(genres[i]) + plays[i]);
            }
        }

        List<String> keySet = new ArrayList<>(genmap.keySet());
        Collections.sort(keySet, (s1, s2) -> genmap.get(s2) - genmap.get(s1));

        for (String key : keySet){
            HashMap<Integer, Integer> map = numberplays.get(key);
            List<Integer> list = new ArrayList<>(map.keySet());

            Collections.sort(list, (s1, s2) -> map.get(s2) - map.get(s1));

            answer.add(list.get(0));
            if (list.size() > 1)
                answer.add(list.get(1));
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}