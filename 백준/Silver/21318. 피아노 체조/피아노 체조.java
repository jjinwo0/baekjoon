import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] musics = new int[N+1];
		int[] scores = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			musics[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N+1; i++) {
			scores[i] = scores[i-1];
			if(musics[i-1] > musics[i]) scores[i]++;
		}
		
		int Q = Integer.parseInt(br.readLine());
		
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sb.append(scores[y] - scores[x]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}