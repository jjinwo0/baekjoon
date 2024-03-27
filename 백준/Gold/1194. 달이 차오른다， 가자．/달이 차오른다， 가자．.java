import java.io.*;
import java.util.*;

public class Main{
	static class node {
		int y;
		int x;
		int count;
		int key;

		public node(int y, int x, int count, int key) {
			this.y = y;
			this.x = x;
			this.count = count;
			this.key = key;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] board = new char[n][m];
		node start = null;
		for (int i = 0; i < n; i++) {
			char[] list = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				board[i][j] = list[j];
				if (board[i][j] == '0') {
					start = new node(i, j, 0, 0);
				}
			}

		}
		System.out.println(bfs(start, board, n, m));

	}

	private static int bfs(node start, char[][] board, int n, int m) {
		int[] dy = { 0, 0, -1, 1 };
		int[] dx = { -1, 1, 0, 0 };
		int answer = -1;
		boolean[][][] visited = new boolean[(1<<6)][n][m];
		Queue<node> queue = new ArrayDeque<>();
		queue.add(start);
		visited[0][start.y][start.x]=true;
		while (!queue.isEmpty()) {
			node current = queue.poll();
			int y = current.y;
			int x = current.x;
			int count = current.count;
			//System.out.println(y+" "+x+" "+count+" "+current.key);
			if(board[y][x]=='1') {
				return count;
			}
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				int key = current.key;
				if (ny < 0 || ny >= n || nx < 0 || nx >= m || board[ny][nx]=='#')continue;
				int num = board[ny][nx] - 'a';
				int num2 = board[ny][nx] - 'A';
				
				if (num >= 0 && num < 6) key = ( key | (1 << num) );
				
				if (num2 >= 0 && num2 < 6 ) {
					if((key&(1<<num2))<=0) continue;
				}
				if (visited[key][ny][nx]) continue;
				visited[key][ny][nx] = true;
				queue.add(new node(ny,nx,count+1,key));
			}

		}
		return -1;
	}

}
