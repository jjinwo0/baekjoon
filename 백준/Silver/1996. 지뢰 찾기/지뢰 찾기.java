import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dX = {1, -1, 0, 0, 1, -1, -1, 1};
        int[] dY = {0, 0, 1, -1, 1, 1, -1, -1};
        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][N];
        char[][] answer = new char[N][N];

        for (int i=0; i<N; i++){
            String temp = br.readLine();
            for (int j=0; j<N; j++){
                arr[i][j] = temp.charAt(j);
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                int count = 0;

                if (arr[i][j] != '.') {
                    answer[i][j] = '*';
                    continue;
                }

                for (int n=0; n<dX.length; n++){
                    int nY = i + dY[n];
                    int nX = j + dX[n];

                    if (nX < 0 || nY < 0 || nX >= N || nY >= N)
                        continue;

                    if (arr[nY][nX] > '0')
                        count += arr[nY][nX] - '0';
                }

                if (count >= 10)
                    answer[i][j] = 'M';

                else
                    answer[i][j] = (char)(count + '0');
            }
        }

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                sb.append(answer[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
