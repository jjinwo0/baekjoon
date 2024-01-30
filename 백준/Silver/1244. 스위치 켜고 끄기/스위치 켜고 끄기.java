import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int switches, students;
    static int[] switchList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        switches = Integer.parseInt(br.readLine());

        switchList = new int[switches+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=1; i<=switches; i++){

            switchList[i] = Integer.parseInt(st.nextToken());
        }

        students = Integer.parseInt(br.readLine());


        for (int i=0; i<students; i++){

            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int switchNumber = Integer.parseInt(st.nextToken());

            if (gender == 1)
                man(switchNumber);

            if (gender == 2) woman(switchNumber);
        }

        for (int i=1; i<=switches; i++){
            sb.append(switchList[i]).append(" ");
            
            if (i % 20 == 0)
                sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void man(int switchNumber) {

        for (int i=switchNumber; i<=switches; i+=switchNumber){

            if (switchList[i] == 1)
                switchList[i] = 0;

            else switchList[i] = 1;
        }
    }

    static void woman(int switchNumber) {

        if (switchList[switchNumber] == 1)
            switchList[switchNumber] = 0;

        else switchList[switchNumber] = 1;

        int left = switchNumber-1;
        int right = switchNumber+1;

        while(left >= 1 && right <= switches && switchList[left] == switchList[right]){

            if (switchList[left] == 1){

                switchList[left] = 0;
                switchList[right] = 0;
            }

            else{

                switchList[left] = 1;
                switchList[right] = 1;
            }

            left -= 1;
            right += 1;
        }
    }
}
