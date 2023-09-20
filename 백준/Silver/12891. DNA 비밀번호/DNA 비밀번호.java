import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] checkArr;
    static int[] myArr;
    static char[] arr;
    static int check;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        checkArr = new int[4]; // 문자 갯수 체크 배열
        myArr = new int[4]; // 슬라이딩 배열에서 dna 문자 갯수 체크
        arr = new char[S]; // 주어진 문자열
        check = 0; // dna 비밀번호 요건 충족 여부를 확인 (각 문자의 조건을 통화 -> check == 4이어야  )

        arr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken()); // 각 문자의 갯수 조건을 담은 배

            if (checkArr[i] == 0)
                check++; // 0이 들어옴 == 해당 문자는 확인할 필요가 없다는 의미 -> check 값을 늘려줌
        }

        for (int i=0; i<P; i++){ // 부분문자열 처음 받고난 후 세팅
            addMyArr(arr[i]);
        }

        if (check == 4)
            answer++;

        // 슬라이딩 윈도우
        for (int i=P; i<S; i++){
            int j = i-P; // 첫 번째 슬라이딩을 마치고 넘어가기 위해
            addMyArr(arr[i]);
            removeMyArr(arr[j]);
            
            if (check == 4)
                answer++;
        }

        System.out.println(answer);
    }

    private static void removeMyArr(char c) {

        switch (c){
            case 'A':
                if (myArr[0] == checkArr[0]) check--;
                myArr[0]--;
                break;

            case 'C':
                if (myArr[1] == checkArr[1]) check--;
                myArr[1]--;
                break;

            case 'G':
                if (myArr[2] == checkArr[2]) check--;
                myArr[2]--;
                break;

            case 'T':
                if (myArr[3] == checkArr[3]) check--;
                myArr[3]--;
                break;

        }
    }

    private static void addMyArr(char c) {

        switch (c){
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) check++;
                break;

            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) check++;
                break;

            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) check++;
                break;

            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) check++;
                break;

        }
    }
}
