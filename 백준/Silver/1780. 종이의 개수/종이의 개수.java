import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int zero_num = 0;
	static int one_num = 0;
	static int minus_num = 0;
	static int[][] graph;
	static int[][] vector = {{0, 0}, {1, 0}, {2, 0}, {0, 1}, {1, 1}, {2, 1}, {0, 2}, {1, 2}, {2, 2}};
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		int N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		func(0, 0, N);
		System.out.println(minus_num);
		System.out.println(zero_num);
		System.out.println(one_num);
	
	}
	
	static void func(int x, int y, int k) {
		int temp = graph[x][y];
		boolean flag = false;
		flag:
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < k; j++) {
				if(temp != graph[x + i][y + j]) {
					flag = true;
					break flag;
				}
			}
		}
		if(flag) {
			for(int[] v : vector) {
				int nx = x + v[0] * k / 3;
				int ny = y + v[1] * k / 3;
				func(nx, ny, k / 3);
			}
		}
		else {
			switch(temp) {
			case -1:
				minus_num++;
				break;
			case 0:
				zero_num++;
				break;
			case 1:
				one_num++;
				break;
			}
				
		}
	}
}
