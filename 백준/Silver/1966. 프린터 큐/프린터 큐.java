import java.io.*;
import java.util.*;


class Docu{ //프린트할 문서 정보를 담는 객체
	int index, weight;
	
	public Docu(int index, int weight) {
		super();
		this.index = index; //현 위치
		this. weight = weight;//중요도 
	}
}

public class Main {
	static Queue<Docu> queue;
	static int N, M;
	static int result; //그래서 찾아야하는 M문서가 몇번째로 출력되는건데!

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i=0;i<T;i++) {
			queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //문서 수
			M = Integer.parseInt(st.nextToken()); // 찾아야하는 것의 현 위치
			
			Integer[] wOrder = new Integer[N]; //중요도만 들어가는 배열
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				int weight = Integer.parseInt(st.nextToken()); //중요도, 입력값
				queue.offer(new Docu(j,weight));//(현위치, 중요도) 큐에 넣어줌
				wOrder[j] = weight;
			}
			
			Arrays.sort(wOrder, Collections.reverseOrder()); //내림차순으로 정렬
			findDocu(wOrder);
			sb.append(result+"\n");
		}
		
		bw.write(sb+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void findDocu(Integer[] wOrder) {
		int cnt = 0; // M이랑 같을 때까지 올려줄거
		int i=0; //내림차순으로 정렬한 프린트물 인덱스
		
		while(!queue.isEmpty()) {
			Docu d = queue.poll(); // 맨앞에 있는 거 뺀다
			
			if(d.weight < wOrder[i]) { //중요도가 낮으면 뒤로 보내준다
				queue.offer(d);
			}
			else {
				cnt++; //프린트했다
				i++; //다음으로 중요도 높은 프린트물을 찾아야한다
				if(d.index == M) { //만약 뽑아낸게 찾아야하는 것과 같다면
					result = cnt;
					return;
				}
			}
		}
	}
}