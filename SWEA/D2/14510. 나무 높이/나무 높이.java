import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter	bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder	sb = new StringBuilder();
		StringTokenizer	st;
		int				testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int		count = Integer.parseInt(br.readLine());
			int[]	tree = new int[count];
			int		max = 0;
			int		odd = 0;
			int		even = 0;
			int		ans;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < count; i++) {
				int temp = Integer.parseInt(st.nextToken());

				max = Math.max(max, temp);
				tree[i] = temp;
			}
			for (int i = 0; i < count; i++) {
				odd		+= (max - tree[i]) % 2;
				even	+= (max - tree[i]) / 2;
			}
            
			int temp = Math.max(even - odd, 0) / 3;
			odd += temp * 2;
			even -= temp;
			int oddEvenMin = Math.min(odd, even);
			ans	=	oddEvenMin * 2 + Math.max((odd - oddEvenMin) * 2 - 1, 0) + (even - oddEvenMin) / 2 * 3 + (even - oddEvenMin) % 2 * 2;
			sb.append("#").append(tc).append(" ").append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}