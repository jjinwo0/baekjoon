import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            int temp = sc.nextInt();
            
            if(list.contains(temp))
                continue;
            
            list.add(temp);
        }
        
        Collections.sort(list);
        
        for(int i : list){
            System.out.print(i + " ");
        }
    }
}