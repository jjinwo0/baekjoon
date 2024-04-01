import java.util.*;
import java.io.*;
public class Solution {
	static class node{
		int y;
		int x;
		int dist;
		
		public node(int y, int x) {
			this.y=y;
			this.x=x;
			this.dist = Math.abs(y)+Math.abs(x);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			node[] nodes = new node[N];
			int max = 0;
			boolean odd = false;
			boolean even = false;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				nodes[i]=new node(y,x);
				if(nodes[i].dist%2==0) {
					even=true;
				}else {
					odd=true;	
				}
				if(nodes[i].dist > nodes[max].dist) {
					max=i;
				}
			}
			
			if(odd && even) {	
				System.out.printf("#%d %d\n",t,-1);
				continue;
			}
			int dist = nodes[max].dist;
			double start =  (int)Math.floor((-1+Math.sqrt(1+8*dist))/2); 
			
			while((((start+1)*start)/2)%2 != (dist % 2) || (((start+1)*start)/2) < dist ) {
				start++;
			}
			
			System.out.printf("#%d %d\n",t,(int)start);
		}
	}
}
