import java.util.*;
import java.io.*;

public class Main{
	static final int p =998244353;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		for(int i=0;i<n;i++) {
			long num = Long.parseLong(br.readLine());
			System.out.println(mulbora(num)[2][1]);
		}
	}
	
	private static long[][] mulbora(long n){
		if(n==1) return new long[][]{{0,1,0},{0,0,1},{1,1,0}};
		
		long[][] temp = mulbora(n/2);
		
		
		if(n%2==0) {
			return multiMatrix(temp,temp);
		}
		return multiMatrix(multiMatrix(temp,temp),mulbora(1));
	}
	
	private static long[][] multiMatrix(long[][] a, long[][] b){
		long[][] answer = new long[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				answer[i][j]=0;
				for(int k=0;k<3;k++) {
					answer[i][j]=(answer[i][j]+(a[i][k]*b[k][j]%p))%p;
				}
			}
		}
		return answer;
	}
}
