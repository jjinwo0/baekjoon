import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] weight;
	static int[] value;
	static int[][] answer;
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] s = br.readLine().split(" ");
			int weight_max = Integer.parseInt(s[1]);
			int count = Integer.parseInt(s[0]);
			weight = new int[count+1];
			value = new int[count+1];
			answer = new int[count+1][weight_max+1];
			for(int i=1;i<=count;i++)
			{
				s = br.readLine().split(" ");
				weight[i]=Integer.parseInt(s[0]);
				value[i]=Integer.parseInt(s[1]);		
			}
			for(int i =1; i<=count;i++)
			{
				int d_wei = weight[i];
				int d_val = value[i];
				for(int j=0;j<=weight_max;j++)
				{
					if(j>=d_wei)
					{
						answer[i][j]=max((answer[i-1][j-d_wei]+d_val),answer[i-1][j]);
						//System.out.println("answer " + i + " " + j+ " = "+ answer[i][j]);
					}
					else
					{
						answer[i][j]=answer[i-1][j];
						//System.out.println("answer " + i + " " + j+ " = "+ answer[i][j]);
					}
				}
			}
			System.out.println(answer[count][weight_max]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static int max(int a, int b) {
		// TODO Auto-generated method stub
		if(a>=b)
		{
			return a;
		}
		else
			
		{
			return b;
		}
		
	}

}
