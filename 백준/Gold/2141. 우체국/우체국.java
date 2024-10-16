import java.io.*;
import java.util.*;
 
public class Main {
    
    static int n;
    static long total = 0;
    static Vector<pair> v = new Vector<pair>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            total += a;
            v.add(new pair(x, a));
        }
        
        Collections.sort(v, new Comparator<pair>() {
            public int compare(pair p1, pair p2) {
                if(p1.first < p2.first) {
                    return -1;
                }
                else if(p1.first == p2.first) {
                    if(p1.second < p2.second) {
                        return -1;
                    }
                }
                return 1;
            }
        });    
        
        long people = 0;
        
        for(pair p : v) {
            people += p.second;
            if(people >= (total + 1) / 2) {
                bw.write(String.valueOf(p.first) + "\n");
                break;
            }
        }
 
        bw.flush();
        bw.close();
    }
}
 
class pair{
    long first, second;
    pair(long f, long s) {
        this.first = f;
        this.second = s;
    }
}