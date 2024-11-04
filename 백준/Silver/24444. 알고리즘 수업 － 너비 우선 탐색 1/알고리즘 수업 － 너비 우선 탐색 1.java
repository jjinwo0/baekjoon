import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int V, idx=0;
	static LinkedList<Integer> e[];
	static int[] order;
	static boolean[] visited;
	static LinkedList<Integer> queue = new LinkedList<Integer>();
			
	public static void main(String[] args) throws IOException {
		int v, w;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer s = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(s.nextToken()); //정점
		int M = Integer.parseInt(s.nextToken()); //간선
		int start = Integer.parseInt(s.nextToken()); //시작 정점
		
		visited = new boolean[N+1];
		order = new int[N+1];

		e = new LinkedList[N+1];
		for (int i=1; i<=N; ++i) {
			e[i]=new LinkedList();
		}
		
		for(int i = 0; i<M; i++) {
			StringTokenizer vw = new StringTokenizer(br.readLine());
			v = Integer.parseInt(vw.nextToken());
			w = Integer.parseInt(vw.nextToken());
			
			//v-w 노드 연결
			e[v].add(w);
			e[w].add(v);
		}
		
		//정렬
		for(int i = 1; i<=N; i++) {
			Collections.sort(e[i]);
            //Collections.sort(e[i], Collections.reverseOrder());
		}
		
		visited[start] = true;
		BFS(start); 
	    System.out.println(print(order));
	}
	
	static void BFS(int r) {
		order[r] = ++idx;
		queue.add(r);

		if (e[r]==null) {			
			return;
		}
		while (!queue.isEmpty()) {
			int u=queue.pollFirst();
			
		    for (int v : e[u]) {		    	
		        if (!visited[v]) { 
		        	order[v] = ++idx;
			        visited[v] = true;
			        queue.add(v);
		        }
		    }
		}
	}
				
	static StringBuilder print(int[] array) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < array.length; i++) {
			sb.append(array[i]).append('\n');
		}
		return sb;
	}
}