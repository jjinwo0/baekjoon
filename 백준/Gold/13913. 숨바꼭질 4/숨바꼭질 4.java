import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//숨바꼭질 4
public class Main {
	static int[] check = new int[100001];
	static int[] before = new int[100001];
	static int N;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		if (N == K) { // 입력이 같을 때
			System.out.println(0);
			System.out.println(N);
		} else {
			findK(N); // bfs
			StringBuilder sb = new StringBuilder(); // 결과 저장
			sb.append(check[K] + "\n");
			Stack<Integer> stack = new Stack<>();
			int after = K; // 뒤에서부터 왔던길 찾아가기
			while (after != N) {
				stack.push(after);
				after = before[after];
			}
			stack.push(N); // 마지막N까지 넣어주기

			while (!stack.isEmpty()) {
				sb.append(stack.pop()).append(" ");
			}

			System.out.println(sb.toString());

		}
	}

	public static void findK(int n) {
		Queue<Integer> que = new LinkedList<>(); // 큐 생성
		que.add(n);

		while (!que.isEmpty()) { // 큐가 빌때까지
			int X = que.poll(); // 현재 X
			if (X == K) // 값이 구해지면 스탑
				break;
			if (X > 0 && check[X - 1] == 0) { // X -1
				que.add(X - 1);
				check[X - 1] = check[X] + 1;
				before[X - 1] = X; // 이전에 들렀던 곳 저장
			}
			if (X + 1 < check.length && check[X + 1] == 0) { // X +1
				que.add(X + 1);
				check[X + 1] = check[X] + 1;
				before[X + 1] = X;
			}
			if (X * 2 < check.length && check[X * 2] == 0) { // X *2
				que.add(X * 2);
				check[X * 2] = check[X] + 1;
				before[X * 2] = X;

			}

		}
	}

}