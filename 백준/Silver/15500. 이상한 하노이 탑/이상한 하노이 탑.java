import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int targetNum = N;
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> First = new LinkedList<Integer>();
		LinkedList<Integer> Second = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			First.add(Integer.parseInt(st.nextToken()));
		}

		while (targetNum > 0) {
			if (First.contains(targetNum)) {
				while (First.size() > 0) {
					int now = First.pollLast();
					if (now == targetNum) {
						sb.append("1 3\n");
						cnt++;
						targetNum--;
						break;
					} else {
						sb.append("1 2\n");
						cnt++;
						Second.add(now);
					}
				}
			} else if (Second.contains(targetNum)) {
				while (Second.size() > 0) {
					int now = Second.pollLast();
					if (now == targetNum) {
						sb.append("2 3\n");
						cnt++;
						targetNum--;
						break;
					} else {
						sb.append("2 1\n");
						cnt++;
						First.add(now);
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}

}