import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Student {
        int y;
        int x;
        int stairNum;
        int stairTime;
        int arriveTime;

        public Student(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Stair {
        int y;
        int x;
        int length;

        public Stair(int y, int x, int length) {
            this.y = y;
            this.x = x;
            this.length = length;
        }
    }

    static int N, answer;

    static ArrayList<Student> students;
    static ArrayList<Stair> stairs;

    static boolean[] visited;

    static Queue<Student>[] sq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");

            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;

            students = new ArrayList<>();
            stairs = new ArrayList<>();

            sq = new LinkedList[2];
            sq[0] = new LinkedList<>();
            sq[1] = new LinkedList<>();

            for (int i=0; i<N; i++){

                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j=0; j<N; j++){
                    int num = Integer.parseInt(st.nextToken());

                    if (num == 1)
                        students.add(new Student(i, j));

                    if (num > 1)
                        stairs.add(new Stair(i, j, num));
                }
            }

            make(0);

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void make(int index) {

        if (index == students.size()){
            visited = new boolean[students.size()];

            int result = go();

            answer = Math.min(result, answer);

            return;
        }

        Student stu = students.get(index);

        stu.stairNum = 0;
        stu.arriveTime = Math.abs(stu.y - stairs.get(stu.stairNum).y)
                + Math.abs(stu.x - stairs.get(stu.stairNum).x);
        make(index + 1);

        stu.stairNum = 1;
        stu.arriveTime = Math.abs(stu.y - stairs.get(stu.stairNum).y)
                + Math.abs(stu.x - stairs.get(stu.stairNum).x);
        make(index + 1);
    }

    private static int go() {

        int count = 0;
        int result = 1;

        while(true) {

            for (Queue<Student> q : sq){

                int size = q.size();

                for (int i=0; i<size; i++){
                    Student stu = q.poll();
                    Stair stair = stairs.get(stu.stairNum);

                    if (stu.stairTime + stair.length <= result)
                        continue;

                    q.offer(stu);
                }
            }

            if (count == students.size() && sq[0].isEmpty() && sq[1].isEmpty())
                return result;

            for (int i=0; i< students.size(); i++){
                if (visited[i])
                    continue;

                Student stu = students.get(i);
                Queue<Student> queue = sq[stu.stairNum];

                if (stu.arriveTime + 1 <= result && queue.size() < 3){
                    stu.stairTime = result;
                    visited[i] = true;
                    queue.offer(stu);
                    count++;
                }
            }

            result++;
        }
    }
}