import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        // 문자열 입력을 받기 위한 BufferedReader 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 문자열을 담은 후 출력을 위한 BufferedWriter 선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력받을 문자열의 갯수를 입력받아 N에 초기화
        int N = Integer.parseInt(br.readLine());

        // N번 반복
        for (int i=0; i<N; i++) {

            // 문자열 입력
            String str = br.readLine();

            // 이동이 필요한 문자를 담기 위한 이동 대기열 Stack 선언
            Stack<Character> move = new Stack<>();

            // 정답 문자열을 담기 위한 문자 Stack 선언
            Stack<Character> answer = new Stack<>();

            // 문자열의 한 글자씩 확인하기 위해 문자열 길이만큼 반복
            for (int j = 0; j < str.length(); j++) {

                // 문자열 한 글자 추출
                Character temp = str.charAt(j);

                if (temp == '<'){ // < 문자가 입력되었을 떄,

                    if (!answer.isEmpty()) // 문자 스택이 비어있지 않다면,
                        move.push(answer.pop()); // 이동 대기열에 적재

                } else if (temp == '>'){ // > 문자가 입력되었을 떄,

                    if (!move.isEmpty()) // 이동 대기열이 비어있지 않다면,
                        answer.push(move.pop()); // 이동을 대기하고 있던 문자 스택에 적재

                } else if (temp == '-'){ // - 문자가 입력되었을 떄,

                    if (!answer.isEmpty()) // 문자 스택이 비어있지 않다면,
                        answer.pop(); // 문자열에서 가장 최근에 담긴 문자 삭제

                } else answer.push(temp); // 이외의 문자들은 모두 문자 스택에 적재한다.
            }

            // 이동 대기열에 적재되어있는 문자가 남아있다면,
            while(!move.isEmpty()){

                // 모두 문자 스택에 적재한다.
                answer.push(move.pop());
            }

            // 문자 스택만큼 반복하고,
            for (int k=0; k<answer.size(); k++){

                // 앞서 선언한 BufferedWriter에 적재 한다.
                bw.write(answer.get(k));
            }
            
            // new line
            bw.write("\n");
        }
        // 출력
        bw.flush();
        bw.close();
    }
}
