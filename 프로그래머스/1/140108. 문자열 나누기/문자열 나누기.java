class Solution {

    static int count = 0;
    
    public static int solution(String str){
        
        substr(str);
        
        return count;
    }

    private static void substr(String str) {


        if (str.length() == 0)
            return;

        char first = str.charAt(0);
        
        int sameCount = 1;
        int otherCount = 0;
        for (int i=1; i<str.length(); i++){

            if (str.charAt(i) == first)
                sameCount++;

            else{
                otherCount++;
            }

            if (sameCount == otherCount){

                String substring = str.substring(i + 1, str.length());
                substr(substring);
                break;
            }
        }
        count++;
    }
}