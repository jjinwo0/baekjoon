import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
        int answer = 0;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            for(int i=0; i<10; i++) {
                int input = sc.nextInt();

                if(input%2 == 1)
                    answer+=input;
            }
        	System.out.println("#"+test_case+" "+answer);
            answer = 0;
		}
        
	}
}