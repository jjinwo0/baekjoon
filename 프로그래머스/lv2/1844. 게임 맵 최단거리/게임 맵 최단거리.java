import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        return bfs(0, 0, maps, visited);
    }
    
    public int bfs(int x, int y, int[][] maps, boolean[][] visited){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{x, y, 1});
        visited[x][y] = true;
        
        int answer = -1;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            x = temp[0];
            y = temp[1];
            int cnt = temp[2];
            
            if(x == n-1 && y == m-1){
                answer = cnt;
                break;
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                
                if(maps[nx][ny] == 0)
                    continue;
                
                if(!visited[nx][ny] && maps[nx][ny] == 1){
                    queue.add(new int[]{nx, ny, cnt + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return answer;
    }
}
