import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] visit;
	
	static long ans;
	static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		} 
		br.readLine();
		for (int i = 1; i < N; i++) {		
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i; j++) {
				int v =Integer.parseInt(st.nextToken());
				list.get(i).add(new Edge(j,v));
				list.get(j).add(new Edge(i,v));
			}
		}
		
		pq.addAll(list.get(0));
		visit[0] = true;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visit[e.next]) continue;
			visit[e.next] = true;
			ans += e.value;
			pq.addAll(list.get(e.next));
			cnt++;
			if(cnt == N-1)
				break;
		}
		System.out.println(ans);
	}
	
	static class Edge{
		int next, value;
		Edge(int n,int v){
			this.next = n;
			this.value = v;
		}
	}
}