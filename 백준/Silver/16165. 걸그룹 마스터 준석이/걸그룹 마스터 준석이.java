import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, ArrayList<String>> groupList = new HashMap<>();
        HashMap<String, String> memberList = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++){
            String group = br.readLine();
            int size = Integer.parseInt(br.readLine());

            ArrayList<String> temp = new ArrayList<>();

            for (int j=0; j<size; j++) {
                String member = br.readLine();
                temp.add(member);
                memberList.put(member, group);
            }

            Collections.sort(temp);

            groupList.put(group, temp);
        }

        for (int i=0; i<M; i++){

            String temp = br.readLine();
            int n = Integer.parseInt(br.readLine());

            if (n == 1){

                System.out.println(memberList.get(temp));
            } else{

                ArrayList<String> find = groupList.get(temp);

                for (String str : find)
                    System.out.println(str);
            }
        }
    }
}
