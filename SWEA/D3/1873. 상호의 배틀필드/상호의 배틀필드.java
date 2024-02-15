import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int H, W, tankX, tankY;

    static char tankStatus;

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];

            tankX = 0;
            tankY = 0;

            for (int i=0; i<H; i++){
                char[] arr = br.readLine().toCharArray();

                for (int j = 0; j < W; j++) {
                    map[i][j] = arr[j];

                    if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>'){
                        tankY = i; tankX = j; tankStatus = map[i][j];
                    }
                }
            }

            int inputCount = Integer.parseInt(br.readLine());
            char[] input = br.readLine().toCharArray();

            playGame(inputCount, input);

            sb.append("#").append(test_case).append(" ");

            for (int i=0; i<H; i++){
                for (int j=0; j<W; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void playGame(int inputCount, char[] input) {

        for (int i=0; i<inputCount; i++){

            char command = input[i];

            if (command == 'S'){
                if (tankStatus == '>'){

                    for (int k=tankX+1; k < W; k++){
                        if (map[tankY][k] == '#')
                            break;

                        if (map[tankY][k] == '*') {
                            map[tankY][k] = '.';
                            break;
                        }
                    }

                }
                if (tankStatus == '^'){

                    for (int k=tankY-1; k >= 0; k--){
                        if (map[k][tankX] == '#')
                            break;

                        if (map[k][tankX] == '*') {
                            map[k][tankX] = '.';
                            break;
                        }
                    }
                }
                if (tankStatus == 'v'){

                    for (int k=tankY+1; k < H; k++){
                        if (map[k][tankX] == '#')
                            break;

                        if (map[k][tankX] == '*') {
                            map[k][tankX] = '.';
                            break;
                        }
                    }
                }
                if (tankStatus == '<'){

                    for (int k=tankX-1; k >= 0; k--){
                        if (map[tankY][k] == '#')
                            break;

                        if (map[tankY][k] == '*') {
                            map[tankY][k] = '.';
                            break;
                        }
                    }
                }
            }

            if (command == 'U'){

                tankStatus = '^';

                if (tankY > 0 && map[tankY-1][tankX] == '.') {
                    map[tankY][tankX] = '.';
                    tankY -= 1;
                    map[tankY][tankX] = tankStatus;
                } else map[tankY][tankX] = tankStatus;
            }

            if (command == 'R'){

                tankStatus = '>';

                if (tankX < W-1 && map[tankY][tankX+1] == '.'){
                    map[tankY][tankX] = '.';
                    tankX += 1;
                    map[tankY][tankX] = tankStatus;
                } else map[tankY][tankX] = tankStatus;
            }

            if (command == 'L'){

                tankStatus = '<';

                if (tankX > 0 && map[tankY][tankX-1] == '.') {
                    map[tankY][tankX] = '.';
                    tankX -= 1;
                    map[tankY][tankX] = tankStatus;
                } else map[tankY][tankX] = tankStatus;
            }

            if (command == 'D'){

                tankStatus = 'v';

                if (tankY < H-1 && map[tankY+1][tankX] == '.') {
                    map[tankY][tankX] = '.';
                    tankY += 1;
                    map[tankY][tankX] = tankStatus;
                } else map[tankY][tankX] = tankStatus;
            }
        }
    }
}
