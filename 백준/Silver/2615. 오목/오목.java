import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int n = 19;
	private static int[][] board = new int[n + 1][n + 1];
	private static boolean[][][] visited = new boolean[n + 1][n + 1][4]; 
	private static int[] dr = { 0, 1, 1, 1 }; 
	private static int[] dc = { 1, 1, 0, -1 }; 

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 입력값 저장
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				if (board[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						if (!visited[i][j][k] && checkStone(i, j, k, board[i][j])) {

							System.out.println(board[i][j]);
							if (k == 3) { 
								System.out.println((i + 4) + " " + (j - 4));
							} else {
								System.out.println(i + " " + j);
							}
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
	}

	private static boolean checkStone(int i, int j, int k, int color) {
		visited[i][j][k] = true;
		int r = i, c = j;
		int cnt = 1;

		while ((r += dr[k]) >= 1 && r <= n && (c += dc[k]) >= 1 && c <= n) {

			if (board[r][c] == color) {
				visited[r][c][k] = true;
				cnt++;
			} else {
				break;
			}
		}

		if (cnt == 5) {
			return true;
		}
		return false;
	}

}