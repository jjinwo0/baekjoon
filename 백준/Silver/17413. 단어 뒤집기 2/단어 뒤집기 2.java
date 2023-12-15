import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<Character>();
		int check = 0; // 태그안인지 아닌지 체크
		String input = sc.nextLine();
		StringBuilder result = new StringBuilder();
		
		for(char ch : input.toCharArray()) {
			if(ch == '<') {
				check+=1; // 태그 안을 의미
                
				while(!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append("<");
			} else if(ch == '>') {
				check-=1; // 태그 탈출
				result.append(">");
			} else if(ch == ' ') {
                
				while(!stack.isEmpty())
					result.append(stack.pop());
				result.append(" ");
			} else {
				if(check == 0)
					stack.push(ch);
				else
					result.append(ch);
			}
		}
		
		// 스택에 남은 문자 뒤집기
		while(!stack.isEmpty())
			result.append(stack.pop());
		
		System.out.println(result);
		sc.close();
		return;
	}
}