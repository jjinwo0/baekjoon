import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<List<Data>> list;
	static int[] dist;
	
	static class Data {
		int num, cost;
		public Data(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "num = " + num + " cost = " + cost;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Data(b, c));
			list.get(b).add(new Data(a, c));
		}
		//입력 완료
		
		dijkstra(0);
		System.out.println(dist[N-1]);
		
		
	}
	
	private static void dijkstra(int start) {
		
		dist = new int[N];
		Arrays.fill(dist, 987654321);
		dist[start] = 0;
		
		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2)->o1.cost-o2.cost);
		pq.add(new Data(start, 0));

		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			if(dist[cur.num] < cur.cost) continue;
			
			for(Data next: list.get(cur.num)) {
				if(dist[next.num] > cur.cost+next.cost) {
					dist[next.num] = cur.cost+next.cost;
					pq.add(new Data(next.num, dist[next.num]));
				}
			}
		}
		
	}

}