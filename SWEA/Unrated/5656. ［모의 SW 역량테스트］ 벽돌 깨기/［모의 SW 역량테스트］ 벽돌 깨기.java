import java.io.*;
import java.util.*;

/**
 * 
 * 
 * 
 * 접근 방법 : 완전 탐색으로 접근시
 * 모든 경우는 W^N 이며, 각각의 경우에 공을 부수는 최악의 경우는 W*H, 공을 내려가게 만드는 최악의 경우 또한 W*H
 * 고로 W^N개의 경우에 대해 각각 2*N*W*H의 시간이 걸린다.
 * 계산시 약 2800만으로 시간안에 해결가능함을 알 수 있다.
 * 
 * @author 박범수
 *
 */
public class Solution{

	static class node {
		int y;
		int x;
		int power;

		public node(int y, int x, int power) {
			this.y = y;
			this.x = x;
			this.power = power;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test_cases = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= test_cases; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int[][] square = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					square[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// W^N 의 경우의 수
			int answer = dropballs(square, N, W, H, 0);
			System.out.printf("#%d %d\n",test_case,answer);
		}

	}

	private static int dropballs(int[][] square, int n, int w, int h, int depth) {
		if (depth == n) {
			return count_bricks(square,h,w);
		}
		//
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < w; i++) {
			int[][] copy = copysquare(square, h, w);
			// 공 깨기
			breakbricks(copy, h, w, i);
			// 공 내리기
			downbricks(copy,h,w);
			answer = Math.min(answer, dropballs(copy, n, w, h, depth + 1));
			//System.out.println("answer :"+ depth + " "+ answer);
		}
//		int[][] copy = copysquare(square, h, w);
//		// 공 깨기
//		breakbricks(copy, h, w, 2);
//		// 공 내리기
//		downbricks(copy,h,w);
//		answer = Math.min(answer, dropballs(copy, n, w, h, depth + 1));
//		System.out.println("answer :"+ depth + " "+ answer);
//		for (int i = 0; i < h; i++) {
//			for (int j = 0; j < w; j++) {
//				System.out.print(square[i][j]);
//			}
//			System.out.println();
//		}
		return answer;
	}

	private static void downbricks(int[][] copy, int h, int w) {
		for(int i=0;i<w;i++) {
			int count =h-1;
			for(int j=h-1;j>=0;j--) {
				if(copy[j][i]!=0) {
					int temp = copy[j][i];
					copy[j][i]=0;
					copy[count--][i]=temp;
					
				}
			}
		}
	}

	private static void breakbricks(int[][] copy, int h, int w, int position) {
		// 초기 위치 찾기
		node start = null;
		for (int i = 0; i < h; i++) {
			if (copy[i][position] != 0) {
				start = new node(i, position, copy[i][position]);
				break;
			}
		}
		if (start == null)
			return;
		int[] dy = { 0, 0, -1, 1 };
		int[] dx = { -1, 1, 0, 0 };
		Queue<node> queue = new ArrayDeque<>();
		queue.add(start);
		copy[start.y][start.x]=0;
		//System.out.println(start.y + " " + start.x + " " + start.power);
		while (!queue.isEmpty()) {
			node now = queue.poll();
			int y = now.y;
			int x = now.x;
			int power = now.power;
			//System.out.println("근원 : "+ y + " "+ x + " " + power);
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= power; j++) {
					int nexty = y + (dy[i] * (j-1));
					int nextx = x + (dx[i] * (j-1));

					if (nexty < 0 || nexty >= h || nextx < 0 || nextx >= w)
						break;

					if (copy[nexty][nextx] == 0)
						continue;

					queue.add(new node(nexty,nextx,copy[nexty][nextx]));
					//System.out.println("터짐 : "+ nexty + " "+ nextx + " " + copy[nexty][nextx]);
					copy[nexty][nextx] = 0;
				}
			}
			//System.out.println("------copy[nexty][nextx]");
		}
	}

	private static int[][] copysquare(int[][] square, int h, int w) {
		int[][] copy = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				copy[i][j] = square[i][j];
			}
		}

		return copy;
	}

	private static int count_bricks(int[][] square, int h, int w) {
		int answer =0;
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(square[j][i]!=0)answer++;
			}
		}
		return answer;
	}
}
