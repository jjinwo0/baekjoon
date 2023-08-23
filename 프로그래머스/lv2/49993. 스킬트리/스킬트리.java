class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String st : skill_trees){
            String temp = st;
            
            for(int i=0; i<st.length(); i++){
                String str = st.substring(i, i+1);
                
                if(!skill.contains(str))
                    temp = temp.replace(str, "");
            }
            
            if(skill.indexOf(temp) == 0)
                answer++;
        }
        
        return answer;
    }
}