import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        visited = new boolean[N+1];
        
        recursion(0);
    }
    
    public static void recursion(int index){
        if (index == M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i=1; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[index] = i;
                recursion(index + 1);
                visited[i] = false;
            }
        }
    }
}
