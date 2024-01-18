import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N*2-1];

        for (int i=0; i<N; i++){
            Arrays.fill(arr[i], ' ');
        }

        inputStar(0, N-1, N);

        for (int i=0; i<N; i++){
            for (int j=0; j<N*2-1; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void inputStar(int y, int x, int N) {

        if (N == 3){

            arr[y][x] = '*';
            arr[y+1][x-1] = arr[y+1][x+1] = '*';
            arr[y+2][x-2] = arr[y+2][x-1] = arr[y+2][x] = arr[y+2][x+1] = arr[y+2][x+2] = '*';

            return ;
        }

        inputStar(y, x, N/2);
        inputStar(y + N/2, x - N/2, N/2);
        inputStar(y + N/2, x + N/2, N/2);
    }
}
