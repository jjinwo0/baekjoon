
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	private static class AirCorn {
		int y;
		int x;

		public AirCorn(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	private static class node {
		int y;
		int x;
		int count;

		public node(int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}

	private static int R, C, T;
	private static int[][] board;

	private static ArrayList<AirCorn> AirCorns = new ArrayList<>();

	private static Queue<node> nodes = new LinkedList<>();
	private static int[] dy = { 1, 0, -1, 0 };
	private static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		R = Integer.parseInt(info[0]);
		C = Integer.parseInt(info[1]);
		T = Integer.parseInt(info[2]);
		board = new int[R][C];

		for (int i = 0; i < R; i++) {
			String[] yInfo = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(yInfo[j]);
				addAirCorn(board[i][j], i, j);
			}
		}

		while (T > 0) {
			findnode();
			diffusenode();
			operateAirCorn("counterclockwise");
			operateAirCorn("clockwise");
			T--;
		}

		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += board[i][j] == -1 ? 0 : board[i][j];
			}
		}
		System.out.println(result);
	}

	private static void addAirCorn(int value, int y, int x) {
		if (value == -1) {
			AirCorns.add(new AirCorn(y, x));
		}
	}

	private static void findnode() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] > 0) {
					nodes.offer(new node(i, j, board[i][j]));
				}
			}
		}
	}

	private static void diffusenode() {

		while (!nodes.isEmpty()) {

			node node = nodes.poll();

			int sum = 0;

			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];

				if (ny >= R || ny < 0 || nx >= C || nx < 0 || board[ny][nx] == -1) {
					continue;
				}

				board[ny][nx] += node.count / 5;

				sum += node.count / 5;
			}

			board[node.y][node.x] -= sum;
		}
	}

	private static void operateAirCorn(String direction) {

		int index = direction.equals("clockwise") ? 1 : 0;
		AirCorn AirCorn = AirCorns.get(index);

		int mr = direction.equals("clockwise") ? 1 : -1;

		int y = AirCorn.y + mr;
		int x = AirCorn.x;

		board[y][x] = 0;

		int yMaxRange = direction.equals("clockwise") ? R : AirCorn.y + 1;
		int yMinyange = direction.equals("clockwise") ? AirCorn.y : 0;

		for (int i = 0; i < 4; i++) {
			while (true) {

				int ny = y + (dy[i] * mr);
				int nx = x + dx[i];

				if (ny >= yMaxRange || ny < yMinyange || nx >= C || nx < 0) {
					break;
				}

				board[y][x] = board[ny][nx] == -1 ? 0 : board[ny][nx];

				y = ny;
				x = nx;
			}
		}
	}
}