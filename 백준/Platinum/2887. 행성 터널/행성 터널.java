import java.util.*;
import java.io.*;

public class Main{
	static class node {
		int num;
		int x;
		int y;
		int z;

		public node(int num, int x, int y, int z) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static class edge implements Comparable<edge> {
		int start;
		int to;
		int weight;

		public edge(int start, int to, int weight) {
			this.start = start;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		node[] nodeList = new node[n];
		parents = new int[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			nodeList[i] = new node(i, x, y, z);
			parents[i] = i;
		}
		PriorityQueue<edge> queue = new PriorityQueue<>();
		// x ㅣ거리
		Arrays.sort(nodeList, (o1, o2) -> Integer.compare(o1.x, o2.x));
		for (int i = 0; i < n - 1; i++) {
			int weight = nodeList[i + 1].x - nodeList[i].x;
			queue.add(new edge(nodeList[i].num, nodeList[i + 1].num, weight));
		}
		// y 거리
		Arrays.sort(nodeList, (o1, o2) -> Integer.compare(o1.y, o2.y));
		for (int i = 0; i < n - 1; i++) {
			int weight = nodeList[i + 1].y - nodeList[i].y;
			queue.add(new edge(nodeList[i].num, nodeList[i + 1].num, weight));
		}
		// z 거리
		Arrays.sort(nodeList, (o1, o2) -> Integer.compare(o1.z, o2.z));
		for (int i = 0; i < n - 1; i++) {
			int weight = nodeList[i + 1].z - nodeList[i].z;
			queue.add(new edge(nodeList[i].num, nodeList[i + 1].num, weight));
		}
		int answer =0;
		while (!queue.isEmpty()) {
			edge now = queue.poll();
			if(union(now.start,now.to)) {
				answer+=now.weight;
			}
		}
		System.out.println(answer);
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		a=find(a);
		b=find(b);
		if(a==b) return false;
		if(a>b) {
			parents[a]=b;
		}else {
			parents[b]=a;
		}
		return true;
	}
}
