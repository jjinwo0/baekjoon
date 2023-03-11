import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        String str;
        int answer = 0;

        str = input.nextLine();

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                answer++;
            }
        }

        if(str.charAt(0) != ' ' && str.charAt(str.length()-1) != ' '){ //첫 번째와 마지막이 공백이 아닌 경우
            answer = answer + 1; 
        }
        if(str.charAt(0) == ' ' && str.charAt(str.length()-1) == ' '){ //첫 번째와 마지막이 공백인 경우
            answer = answer - 1;
        }
        System.out.println(answer);
        
    }
}