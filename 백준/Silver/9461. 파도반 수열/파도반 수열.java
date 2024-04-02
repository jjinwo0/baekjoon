import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] list = new long[100];
		list[0] = 1;
		list[1] = 1;
		list[2] = 1;
		list[3] = 2;
		list[4] = 2;

		for (int i = 5; i <= 99; i++) {
			list[i] = (list[i - 1] + list[i - 5]);
		}
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(list[num - 1]);
		}
	}
}
