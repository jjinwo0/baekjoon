import java.util.*;

public class Main {
	static int[] dp;
	static ArrayList<Integer>[] tree;
	static int[] visited;
	static int n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		int r = scan.nextInt();
		int q = scan.nextInt();

		tree = new ArrayList[n + 1];
		dp = new int[n + 1];
		visited = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < n - 1; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			tree[x].add(y);
			tree[y].add(x);
		}

		// Start!
		visited[r] = 1;
		func(r);

		for (int i = 0; i < q; i++) {
			int idx = scan.nextInt();
			System.out.println(dp[idx]);
		}
	}

	public static int func(int idx) {

		int res = 1;

		if (dp[idx] == 0) {
			ArrayList<Integer> list = tree[idx];

			for (Integer val : list) {
				if (visited[val] == 0) {
					visited[val] = 1;
					res += func(val);
				}
			}

			dp[idx] = res;
		}

		return dp[idx];
	}
}