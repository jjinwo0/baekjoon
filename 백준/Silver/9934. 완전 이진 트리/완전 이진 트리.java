import java.io.*;
import java.util.*;

public class Main {

    public static int K;
    public static ArrayList<Integer> nums;
    public static ArrayList<Integer> [] ans;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 노드 정보 입력 받기 (중위 순회 결과)
        while(st.hasMoreElements()){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        ans = new ArrayList[K];
        for(int i=0; i<ans.length; i++){
            ans[i] = new ArrayList<>();
        }

        solution(0, 0, nums.size()-1);

        for(ArrayList<Integer> line : ans){
            for(int num : line){
                bw.write(num +" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static void solution(int depth, int start, int end){

        int n = (int) Math.floor((double) (start+end)/2);
        // 현재 레벨에 요소 삽입
        ans[depth].add(nums.get(n));

        if(end - start ==0){
            return;
        }
        solution(depth+1, start, n-1);
        solution(depth+1, n+1, end);
    }

}