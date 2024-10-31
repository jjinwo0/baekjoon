import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = in.nextInt();
		int M = in.nextInt();

		HashMap<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < N; i++) {
			String url = in.next();
			String pass = in.next();
			

			map.put(url, pass);
		}

		for (int i = 0; i < M; i++) {
			String url = in.next();
			bw.write(map.get(url) + "\n");
		}
		
		bw.flush();
	}

}