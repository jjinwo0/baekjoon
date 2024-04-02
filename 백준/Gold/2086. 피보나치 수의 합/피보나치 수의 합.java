import java.util.*;
import java.io.*;
public class Main{
	static final int p =1000000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		System.out.println(minus(a,b));
	}
	private static long minus(long a, long b ) {
		long[][] aMatrix = findfibo(a);
		long[][] bMatrix = findfibo(b);
		
		long answer = ((bMatrix[0][0]+bMatrix[0][1]-1)%p - (aMatrix[0][0]-1)%p + p)%p;	
		return answer;
	}
	private static long[][] findfibo(long n) {	
		if(n==0) return new long[][] {{1,0},{0,0}};
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
