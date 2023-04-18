import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static int solution(int[] common) {
        int answer = 0;
        int diff = 0;
        
        if((common[1] - common[0]) == (common[2] - common[1])){
            diff = common[1] - common[0];
            answer = common[common.length - 1] + diff;
        }
        else if((common[1] / common[0]) == (common[2] / common[1])){
            diff = common[1] / common[0];
            answer = common[common.length - 1] * diff;
        }
        return answer;
    }
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] data = {1,2,3,4};

		System.out.println(solution(data));
	}
}