import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>(N);

        for (int i=0; i<N; i++){
            String book = sc.next();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        LinkedList<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());

        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<String> keyList = new ArrayList<>();

        keyList.add(entries.getFirst().getKey());

        for (int i=1; i< entries.size(); i++){
            if (entries.getFirst().getValue() == entries.get(i).getValue())
                keyList.add(entries.get(i).getKey());
        }

        keyList.sort(String::compareTo);

        System.out.println(keyList.get(0));
    }
}
