import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M, D, endTurn, answer;

    static int[][] map;

    static int[] archer;

    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        endTurn = 0;
        answer = Integer.MIN_VALUE;

        map = new int[N][M];
        archer = new int[M];
        isSelected = new boolean[M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);

        System.out.println(answer);
    }

    private static void combination(int index, int depth) {

        if (index == 3){

            answer = Math.max(answer, start());

            return;
        }

        for (int i=depth; i<M; i++){
            if (!isSelected[i]) {
                isSelected[i] = true;
                archer[index] = i;
                combination(index + 1,i+1);
                isSelected[i] = false;
            }
        }
    }

    private static int start() {

        int score = 0;
        int[][] tempMap = new int[N][M];

        for (int i=0; i<N; i++)
            tempMap[i] = map[i].clone();

        for (int i=N-1; i>=0; i--) { // 궁수의 공격 범위

            ArrayList<int[]> temp = new ArrayList<>();

            for (int j=0; j<3; j++){
                int min = D;
                int killX = Integer.MAX_VALUE;
                int killY = -1;

//                System.out.println("내 위치 (y,x)  == " + "(" + (i+1) + "," + archer[j] + ")");
                for (int y=D-1; y>=0; y--){
                    for (int x=archer[j]-y; x<=archer[j]+y; x++){
                        int ny = i-(D-1)+y; // 내가 공격할 수 있는 적군의 y좌표
                        int nx = x; // 내가 공격할 수 있는 적군의 x좌표

                        int dist = Math.abs(archer[j] - nx) + Math.abs(ny - (i + 1));
//                        System.out.println("적군의 (y,x)  == " + "(" + ny + "," + nx + ")");

                        if (nx >= 0 && ny >= 0 && nx < M && ny < N && tempMap[ny][nx] == 1){

                           if(min == dist && killX > nx){
                                killY = ny;
                                killX = nx;
                           }
                           if(min > dist){
                               min = dist;
                               killY = ny;
                               killX = nx;
                           }
                        }
                    }
//                    System.out.println();
                }

                if (killY != -1 && tempMap[killY][killX] == 1){
                    temp.add(new int[]{killY, killX});
//                    tempMap[killY][killX] = 0;
//                    score++;
                }
            }

            for (int[] loc : temp){
                if (tempMap[loc[0]][loc[1]] == 1) {
                    tempMap[loc[0]][loc[1]] = 0;
                    score++;
                }
            }
        }

        return score;
    }
}


/*
6 5 1
1 0 1 0 1
0 1 0 1 0
1 1 0 0 0
0 0 0 1 1
1 1 0 1 1
0 0 1 0 0


6 5 2
1 0 1 0 1
0 1 0 1 0
1 1 0 0 0
0 0 0 1 1
1 1 0 1 1
0 0 1 0 0
*/