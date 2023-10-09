import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st;

        for (int i=0; i<T; i++){

            st = new StringTokenizer(br.readLine()," ");

            while(st.hasMoreTokens())
                list.add(st.nextToken());

            while(true){
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();st.nextToken();

                String sound = st.nextToken();

                if (sound.equals("the")){
                    st = null;
                    break;
                }

                for (int j=0; j<list.size(); j++){

                    if (list.get(j).equals(sound)) {
                        list.remove(j);
                        j--;
                    }
                }
            }

            for(int j=0;j<list.size();j++) sb.append(list.get(j)+" ");
            System.out.println(sb.toString());
            sb.setLength(0);
            list.clear();
        }
    }
}
