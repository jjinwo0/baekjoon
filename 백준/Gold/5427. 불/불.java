import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int W, H;
	public static int answer = 0;
	public static char[][] map;
	public static Queue<Node> fireQ = new LinkedList<>();
	public static Queue<Node> peopleQ = new LinkedList<>();
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int T= Integer.parseInt(st.nextToken());
    	
    	for(int t = 0; t < T; t ++) {
    		st = new StringTokenizer(br.readLine());
    		W = Integer.parseInt(st.nextToken());
        	H = Integer.parseInt(st.nextToken());
        	map = new char[H][W];
        	
        	peopleQ = new LinkedList<Node>();
        	fireQ = new LinkedList<Node>();
        	for(int i=0;i<H;i++) {
        		st = new StringTokenizer(br.readLine());
        		String str = st.nextToken();
        		for(int j=0;j<W;j++) {
        			map[i][j] = str.charAt(j);
        			
        			if(map[i][j] == '@') {
        				peopleQ.add(new Node(i, j, 0));
        			}
        			else if(map[i][j] == '*' ) {
        				fireQ.add(new Node(i, j, 0));
        			}
        		}
        	}
        	answer = -1;
        	answer = simulate();
        	if(answer == -1)
        		System.out.println("IMPOSSIBLE");
        	else 
        		System.out.println(answer);
    	}
    	
    }
    
    public static int simulate() {
    	int[] dx = {-1,1,0,0};
    	int[] dy = {0,0,-1,1};
    	
    	boolean successFlag = false;
    	int moveCnt = 0;
    	while(successFlag == false && moveCnt <= H*W) {
    		moveCnt += 1;
    		
    		if(peopleQ.isEmpty()) {
    			break;
    		}
    		
    		int fireQSize = fireQ.size();
    		int fireCnt = 0;
    		while(!fireQ.isEmpty()) {
        		Node temp = fireQ.poll();
        		
        		for(int dir = 0; dir < 4; dir++) {
        			int nr = temp.r + dx[dir];
        			int nc = temp.c + dy[dir];
        			if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
        			if(map[nr][nc] == '#') continue;
        			if(map[nr][nc] == '*') continue;
        			
        			map[nr][nc] = '*';
        			fireQ.offer(new Node(nr, nc, 0));
        		}
        		fireCnt += 1;
        		
        		if(fireQSize == fireCnt) {
        			fireCnt = 0;
        			fireQSize = fireQ.size();
        			break;
        		}
        	}
        	
        	int peopleQSize = peopleQ.size();
        	int peopleCnt = 0;
        	while(!peopleQ.isEmpty()) {
        		
        		Node temp = peopleQ.poll();
        		for(int dir = 0; dir < 4; dir++) {
        			int nr = temp.r + dx[dir];
        			int nc = temp.c + dy[dir];
        			//만약 범위밖으로 나간다면 성공이다.
        			if(nr < 0 || nr >= H || nc < 0 || nc >= W) {
        				successFlag = true;
        				return temp.cnt + 1;
        			}
        			if(map[nr][nc] == '#') continue;
        			if(map[nr][nc] == '*') continue;
        			if(map[nr][nc] == '@') continue;
        			
        			map[nr][nc] = '@';
        			peopleQ.offer(new Node(nr, nc, temp.cnt + 1));
        		}
        		peopleCnt += 1;
        		if(peopleQSize == peopleCnt) {
        			peopleQSize = peopleQ.size();
        			peopleCnt = 0;
        			break;
        		}
        	}
        	
    	}
    	
    	
    	return -1;
    	
    }
}
class Node{
	int r;
	int c;
	int cnt;
	public Node(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}