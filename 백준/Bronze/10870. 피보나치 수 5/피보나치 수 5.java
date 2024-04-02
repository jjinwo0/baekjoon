import java.util.*;
import java.io.*;
/**
 * [B2] 백준 10870 피보나치수5
 * 메모리 : 14192KB
 * 시간 : 124ms
 * 코드 길이 : 569B
 * 
 * @author 박범수
 * @see <a href="https://www.acmicpc.net/problem/10870">
 */

public class Main 
{	

    public static void main(String[] args) throws NumberFormatException, IOException {
    	// 입력 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        System.out.println(fibo(a));
    	
    }
    
    public static int fibo(int n) {
    	if(n==0) {
    		return 0;
    	}
    	if(n==1) {
    		return 1;
    	}
    	return fibo(n-1)+fibo(n-2);
    }
}



