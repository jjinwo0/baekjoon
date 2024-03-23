import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int k = 0;
        int l = 0;

        for(int i = 0; i < N; i++) {
            String t = br.readLine();
            if(t.startsWith("1") || t.startsWith("2")) {
                String[] tArr = t.split(" ");
                k = Integer.parseInt(tArr[0]);
                l = Integer.parseInt(tArr[1]);
            } else {
                k = Integer.parseInt(t);
            }

            switch(k) {
                case 1:
                    queue.addFirst(l);
                    break;
                case 2:
                    queue.add(l);
                    break;
                case 3:
                    if(queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.pollFirst()).append("\n");
                    }
                    break;
                case 4:
                    if(queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.pollLast()).append("\n");
                    }
                    break;
                case 5:
                    sb.append(queue.size()).append("\n");
                    break;
                case 6:
                    if(queue.isEmpty()) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case 7:
                    if(queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.peekFirst()).append("\n");
                    }
                    break;
                case 8:
                    if(queue.isEmpty()) {
                        sb.append("-1").append("\n");
                    } else {
                        sb.append(queue.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}