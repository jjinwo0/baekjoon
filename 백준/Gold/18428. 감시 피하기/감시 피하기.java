import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static String[][] map;
    static ArrayList<int[]> teachers;
    static String answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        teachers = new ArrayList<>();
        map = new String[N][N];
        answer = "NO";

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++){
                map[i][j] = st.nextToken();

                if (map[i][j].equals("T"))
                    teachers.add(new int[]{i, j});
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int path) {

        if (path == 3){
            if (check())
                answer = "YES";
            return;
        }

        for (int i=0; i<map.length; i++){
            for (int j=0; j<map[i].length; j++){
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    dfs(path+1);
                    map[i][j] = "X";
                }
            }
        }
    }

    private static boolean check() {

        for (int i=0; i< teachers.size(); i++){

            int[] loc = teachers.get(i);

            for (int n = loc[0]-1; n >= 0; n--) {
                if (map[n][loc[1]].equals("O"))
                    break;

                if (map[n][loc[1]].equals("S"))
                    return false;
            }

            for (int n=loc[0]+1; n<map.length; n++){
                if (map[n][loc[1]].equals("O"))
                    break;

                if (map[n][loc[1]].equals("S"))
                    return false;
            }

            for (int n = loc[1]-1; n >= 0; n--) {
                if (map[loc[0]][n].equals("O"))
                    break;

                if (map[loc[0]][n].equals("S"))
                    return false;
            }

            for (int n=loc[1]+1; n<map[0].length; n++){
                if (map[loc[0]][n].equals("O"))
                    break;

                if (map[loc[0]][n].equals("S"))
                    return false;
            }
        }

        return true;
    }
}
