import java.io.*;
import java.util.*;

public class Main {
    static int N, M, r, c, count;
    static int d; // 0은 북쪽, 1은 동쪽, 2는 남쪽, 3은 서쪽
    static int[] dx = {0, 1, 0, -1}; // 북 동 남 서 
    static int[] dy = {-1, 0, 1, 0};
    static int[][] room;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
        
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                // 0은 빈 칸, 1은 벽
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 1;
        cleanRoom(r, c, d);
        System.out.println(count);

        br.close(); 
    }
    
    private static void cleanRoom(int y, int x, int direction) {
        room[y][x] = -1;    
        
        for(int i=0; i<4; i++) {
            direction = (direction + 3) % 4; // 반시계 방향으로 90도
            int ny = y+dy[direction];
            int nx = x+dx[direction];
            
            if(ny>=0 && ny<N && nx>=0 && nx<M && room[ny][nx] == 0) {
                count++;
                cleanRoom(ny, nx, direction);
                
                return;
            }
        }
        
        // 빈 칸이 없는 경우
        int back = (direction+2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        
        if(by>=0 && by<N && bx>=0 && bx<M && room[by][bx] != 1) {
            cleanRoom(by, bx, direction);
        }
    }
}