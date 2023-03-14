class Solution {    public int solution(int[] arr){
        int answer = 0;

        if (arr.length == 1)
            return arr[0];

        int n = gcd(arr[0], arr[1]);
        answer = (arr[0] * arr[1]) / n;

        if (arr.length > 2){
            for (int i=2; i<arr.length; i++){
                n = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / n;
            }
        }

        return answer;
    }
    int gcd(int x, int y){
        int n = x % y;
        if (n == 0)
            return y;
        else return gcd(y, n);
    }
}