import java.util.*;
import java.io.*;

public class Main{
	static class node{
		int y;
		int x;
		public node(int y, int x) {
			this.y=y;
			this.x=x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			boolean[][] canMove = new boolean[n+2][n+2];
			node[] list = new node[n+2];
			for(int i=0;i<n+2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list[i]=new node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			for(int i=0;i<n+2;i++) {
				for(int j=0;j<n+2;j++) {
					int y_dist = Math.abs(list[i].y-list[j].y);
					int x_dist = Math.abs(list[i].x-list[j].x);
					if(y_dist + x_dist <= 1000) {
						canMove[i][j]=true;
					}
				}
			}
			if(bfs(canMove,n+1)) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
			
		
	}
	private static boolean bfs(boolean[][] canMove, int last) {
		
		boolean visited[] = new boolean[last+1];
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		visited[0]=true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now == last) return true;
			for(int i=0;i<=last;i++) {
				if(canMove[now][i] && !visited[i]) {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
		return false;
	}
	
}
