import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main{

	static class node {
		int y;
		int x;

		public node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int[] nums = new int[] {0,5,5,5,5,5};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = 10;
		int board[][] = new int[n][n];

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = btk(board,n);
		if(answer>=1000000) {
			answer=-1;
		}
		System.out.println(answer);
	}

	private static int btk(int[][] board, int n) {
		int min = 1000000;
		node now = findOne(board,n);
		if(now==null) return 0;
		
		for(int i=1;i<=5;i++) {
			if(nums[i]<=0) continue;
			
			int answer =1000000;
			
			if(doColor(board,now,i)) {
				nums[i]--;
				answer = btk(board,n)+1;
				backColor(board,now,i);
				nums[i]++;
			}
			min=Math.min(min, answer);
		}

		return min;
	}
	
	private static void backColor(int[][] board, node now, int n) {
		int y = now.y;
		int x = now.x;
		for(int i=y;i<y+n;i++) {
			for(int j=x;j<x+n;j++) {
				board[i][j]=1;
			}
		}
		
	}

	private static boolean doColor(int[][] board, node now, int n) {
		int y = now.y;
		int x = now.x;
		if(y+n>10||x+n>10) return false;
		
		for(int i=y;i<y+n;i++) {
			for(int j=x;j<x+n;j++) {
				if(board[i][j]!=1) return false;
			}
		}
		
		for(int i=y;i<y+n;i++) {
			for(int j=x;j<x+n;j++) {
				board[i][j]=0;
			}
		}
		return true;
	}
	
	
	private static node findOne(int[][] board, int n) {
		int min = Integer.MAX_VALUE;
		int y=-1;
		int x=-1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(board[i][j]==1) {
					return new node(i,j);
				}
			}
		}
	
		return null;
	}
}
