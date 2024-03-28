import java.util.*;
import java.io.*;

public class Main{
	static class node {
		int y;
		int x;
		int count;

		public node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public node(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] board = new char[n][m];
		node sonic = null;
		node biber = null;
		ArrayList<node> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				board[i][j] = temp[j];
				if (board[i][j] == 'D') {
					biber = new node(i, j);
				}
				if (board[i][j] == 'S') {
					sonic = new node(i, j, 0);
				}
				if (board[i][j] == '*') {
					list.add(new node(i, j));
				}
			}
		}
		// 물판 깔기
		int[][] water = movewater(board, list, n, m);
		//System.out.println(Arrays.deepToString(water));
		int answer = moveSonic(board, water, n, m, sonic, biber);
		if (answer < 0) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(answer);
		}
	}

	private static int moveSonic(char[][] board, int[][] water, int n, int m, node sonic, node biber) {
		int[] dy = { 0, 0, -1, 1 };
		int[] dx = { -1, 1, 0, 0 };
		int answer = -1;
		Queue<node> queue = new ArrayDeque<>();

		boolean[][] visited = new boolean[n][m];

		queue.add(sonic);
		visited[sonic.y][sonic.x] = true;

		while (!queue.isEmpty()) {
			node now = queue.poll();
			int y = now.y;
			int x = now.x;
			int time = now.count;
			//System.out.println(y + " " + x + " " + time);
			if (y == biber.y && x == biber.x) {
				return time;
			}
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
					if (board[ny][nx] == 'X' || water[ny][nx] <= time+1)
						continue;
					queue.add(new node(ny, nx, time + 1));
					visited[ny][nx] = true;
				}
			}

		}

		return answer;
	}

	private static int[][] movewater(char[][] board, ArrayList<node> list, int n, int m) {
		int[] dy = { 0, 0, -1, 1 };
		int[] dx = { -1, 1, 0, 0 };
		int[][] water = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				water[i][j]=2501;
			}
		}
		boolean[][] visited = new boolean[n][m];
		Queue<node> queue = new ArrayDeque<>();
		for (node nod : list) {
			queue.add(nod);
			visited[nod.y][nod.x] = true;
			water[nod.y][nod.x]=0;
			//System.out.println(nod.y + " " + nod.x);
		}

		while (!queue.isEmpty()) {
			node now = queue.poll();
			int y = now.y;
			int x = now.x;
			int nexttime = water[y][x] + 1;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
					if (board[ny][nx] == 'X' || board[ny][nx] == 'D') continue;
					queue.add(new node(ny, nx));
					visited[ny][nx] = true;
					water[ny][nx] = nexttime;
				}
			}
		}
		return water;
	}
}
