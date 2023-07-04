import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] commands = new String[n];
        for (int i=0; i<n; i++) {
            commands[i] = String.valueOf(br.readLine());
        }
        int cnt=1;
        String temp = commands[0];


        while(cnt<n){
            if (temp.length()<2){
                if (!temp.equals(commands[cnt])) {
                    temp = "?";
                    break;
                }
            }
            for (int i=1; i<=temp.length(); i++){
                if (!(temp.substring(i-1, i).equals(commands[cnt].substring(i-1, i)))) {
                    temp = temp.substring(0, i - 1) + "?" + temp.substring(i);
                }
            }
            cnt++;
        }
        System.out.println(temp);
    }
}