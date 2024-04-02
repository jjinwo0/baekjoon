import java.util.*;
import java.io.*;
public class Main{
	static final int p =1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		System.out.println(findfibo(n)[1][0]);
	}
	private static long[][] findfibo(long n) {
		if(n==1) return new long[][] {{1,1},{1,0}};
		
		long[][] matrix = findfibo(n/2);
		if(n%2==0) {
			return doMatrix(matrix,matrix);
		}else{
			return doMatrix(doMatrix(matrix,matrix),findfibo(1));
		}
	}
	private static long[][] doMatrix(long[][] a , long[][] b){
		long[][] answer = new long[2][2];
		
		answer[0][0]= ((a[0][0]*b[0][0])%p+ (a[0][1]*b[1][0])%p)%p;
		answer[0][1]= ((a[0][0]*b[0][1])%p+ (a[0][1]*b[1][1])%p)%p;
		answer[1][0]= ((a[1][0]*b[0][0])%p+ (a[1][1]*b[1][0])%p)%p;
		answer[1][1]= ((a[1][0]*b[0][1])%p+ (a[1][1]*b[1][1])%p)%p;
		
		return answer;
	}
}
