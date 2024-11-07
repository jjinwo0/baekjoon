import java.util.*;
import java.io.*;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] graph;
    static int result[];
    static int cnt=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken()); // 정점의수
        int m=Integer.parseInt(st.nextToken()); // 간선집합
        int r=Integer.parseInt(st.nextToken()); // 시작정점

        graph=new ArrayList[n+1];
        visited=new boolean[n+1];
        result=new int[n+1];

        for(int i=0; i< visited.length; i++){
            result[i]=0; // 결과를 담을 배열 초기화
        }

        for(int i=0; i<n+1; i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(ArrayList<Integer> list: graph){
            Collections.sort(list,Collections.reverseOrder()); // 내림차순 정렬
        }

        dfs(r); // 호출

        StringBuilder sb=new StringBuilder();
        for(int i=1; i<result.length-1; i++){
            sb.append(result[i]).append("\n");
        }
        sb.append(result[result.length-1]);
        System.out.println(sb);
    }

    public static void dfs(int r){
        visited[r]=true; // 해당 노드 방문처리
        result[r]=cnt++; // 결괴배열에 방문 순서 카운트 증가

        for(int i: graph[r]){
           if(!visited[i]){ // 방문하지 않았다면 다시 호출
               dfs(i);
           }
        }
    }
}