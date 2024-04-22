import java.util.*;
import java.io.*;

public class Main{

	static class box implements Comparable<box>{
		int prior;
		int height;
		int weight;
		int count;
		public box(int prior, int height, int weight, int count) {
			this.prior=prior;
			this.height=height;
			this.weight=weight;
			this.count=count;
		}
		@Override
		public int compareTo(box o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.prior, this.prior);
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		box[] boxes = new box[n];
		int count=1;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			boxes[i]=new box(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),count++);
		}
		int[] answers = new int[n];
		int[] parents = new int[n];
		Arrays.sort(boxes);
		for(int i=0;i<n;i++) {
			int max=0;
			int parent=i;
			for(int j=0;j<i;j++) {
				if(boxes[j].weight>=boxes[i].weight&&answers[j]>max) {
					max=answers[j];
					parent=j;
				}
			}
			answers[i]=max+boxes[i].height;
			parents[i]=parent;
		}
		int max=0;
		int index=0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(max<=answers[i]) {
				max=answers[i];
				index=i;
			}
		}
		list.add(boxes[index].count);
		int nextindex=parents[index];
		while(index!=nextindex) {
			list.add(boxes[nextindex].count);
			index=nextindex;
			nextindex=parents[index];
		}
		System.out.println(list.size());
		for(int num : list) {
			System.out.println(num);
		}
	}

}
