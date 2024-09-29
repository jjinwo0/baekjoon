import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //백준 풀때는 Scanner 보단 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력을 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        //문자열 끊어서 받기 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //LinkedHashMap 생성
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            //문자열 숫자 변환
            int num = Integer.parseInt(st.nextToken());
            // 해시맵 안에 num이 있으면 기존 값에 +1을 해주어 저장
            // 존재하지 않으면 새로 값을 추가
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 키를 모두 ArrayList에 저장
        List<Integer> list = new ArrayList<>(map.keySet());

        // ArrayList에 저장된 값 기준 내림차순으로 정렬
        //비교를 위해 Collections 클래스의 sort 메소드 이용
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                //list.get(b) 와 list.get(a)의 위치가 바뀌면 오름차순이 됨
                return Integer.compare(map.get(b), map.get(a));
            }
        });

        //Iterator로 순회하여 출력
        Iterator<Integer> it = list.iterator();
        //Iterator it 에 다음 값이 없을때까지 반복하여 sb에 저장
        while (it.hasNext()) {
            Integer element = it.next();
            for (int i = 0; i < map.get(element); i++) {
                sb.append(element + " ");
            }
        }
        System.out.println(sb);
    }
}