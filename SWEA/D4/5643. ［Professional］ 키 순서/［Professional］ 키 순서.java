import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case =1; test_case<=T;test_case++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			ArrayList<Integer> list[] = new ArrayList[N+1];
			ArrayList<Integer> rev[] = new ArrayList[N+1];
			for(int i=1;i<=N;i++) {
				list[i]=new ArrayList<>();
				rev[i]=new ArrayList<>();
			}
			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				list[a].add(b);
				rev[b].add(a);
			}
			int answer =0;
			for(int i=1;i<=N;i++) {
				int up = find(i,rev,N);
				int down = find(i,list,N);
				if(up+down==(N-1)) answer++;
			}
			System.out.printf("#%d %d\n",test_case,answer);
		}
	}
	private static int find(int i, ArrayList<Integer>[] list,int n) {
		int count=-1;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[n+1];
		queue.add(i);
		visited[i]=true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			count++;
			for(int num : list[now]) {
				if(visited[num]) continue;
				queue.add(num);
				visited[num]=true;
			}
		}
		return count;
	}
}
