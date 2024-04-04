import java.util.*;
import java.io.*;
public class Solution{

	static class node implements Comparable<node>{
		int y;
		int x;
		int weight;
		public node(int y, int x, int weight) {
			this.y = y;
			this.x = x;
			this.weight=weight;
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] board = new int[N][N];
			for(int i=0;i<N;i++) {
				char[] temp = br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					board[i][j] = temp[j] -'0';
				}
			}
			
			System.out.printf("#%d %d\n",t,bfs(board,N));
			
			
		}
	}
	private static int bfs(int[][] board, int n) {
		int[] dy= {-1,1,0,0};
		int[] dx= {0,0,1,-1};
		boolean visited[][] = new boolean[n][n];
		int answer[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			Arrays.fill(answer[i], 10000000);
		}
		PriorityQueue<node> queue = new PriorityQueue<>();
		queue.add(new node(0,0,0));
		visited[0][0]=true;
		answer[0][0]=0;
		while(!queue.isEmpty()) {
			node now = queue.poll();
			int y=now.y;
			int x=now.x;
			visited[y][x]=true;
			//System.out.println("now : "+y+" "+ x + " : "+ answer[y][x]);
			for(int i=0;i<4;i++) {
				int ny=y+dy[i];
				int nx=x+dx[i];
				if(ny<0||ny>=n||nx<0||nx>=n||visited[ny][nx]) continue;
				answer[ny][nx]=Math.min(answer[ny][nx], answer[y][x]+board[ny][nx]);
				queue.add(new node(ny,nx,answer[ny][nx]));
				//System.out.println("next : "+ny+" "+ nx + " : "+ answer[ny][nx]);
				
			}
		}
		//System.out.println(Arrays.deepToString(answer));
		return answer[n-1][n-1];
	}
}
