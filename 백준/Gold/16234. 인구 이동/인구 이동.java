import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
//public class Main {
    public static int[] dirX = {0, 1, 0, -1};   
    public static int[] dirY = {-1, 0, 1, 0};

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean BFS(Queue<Pos> queue, boolean[][] check, int[][] arr, int L, int R){
        int sum = 0;
        List<Pos> currUnion = new ArrayList<>();

        while(!queue.isEmpty()){
            Pos currPos = queue.poll();
            int currX = currPos.x;
            int currY = currPos.y;

            for(int i = 0; i < 4; i++){
                int nextX = currX + dirX[i];
                int nextY = currY + dirY[i];
                if((nextX >= 0 && nextX < arr.length) && (nextY >= 0 && nextY < arr.length)){  
                    if(!check[nextY][nextX]){       //아직 방문하지 않았으면
                        int div = Math.abs(arr[currY][currX] - arr[nextY][nextX]);   
                        if(div >= L && div <= R){
                            queue.add(new Pos(nextX, nextY));      
                            check[nextY][nextX] = true;             
                            sum += arr[nextY][nextX];
                            currUnion.add(new Pos(nextX, nextY));
                        }
                    }
                }
            }
        }
        if(currUnion.size() >= 2){
            int unitedNum = sum / currUnion.size();  
            for(Pos pos : currUnion){
                arr[pos.y][pos.x] = unitedNum;
            }
            return true;
        }
        else return false;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());       
        int L = Integer.parseInt(stringTokenizer.nextToken());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[size][size];
        for(int i = 0; i < size; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < size; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int day = 0;
        Queue<Pos> queue = new LinkedList<>();

        while(true){
            boolean areTheyUnited = false;
            boolean[][] check = new boolean[size][size];

            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(check[i][j] == false){
                        queue.add(new Pos(j, i));
                        if(BFS(queue, check, arr, L, R)) {
                            areTheyUnited = true;
                        }
                    }
                }
            }
            if(areTheyUnited){
                day++;
            }
            else break;
        }

        System.out.println(day);
    }
}