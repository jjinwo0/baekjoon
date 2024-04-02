import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			System.out.printf("#%d %d\n", t, doSum(B).subtract(doSum(A - 1)));
		}
	}

	private static BigInteger doSum(long num) {
		if (num < 0) {
			return BigInteger.ZERO;
		}
		long num2 = num;
		// 자투리 구하기
		BigInteger jaturi = new BigInteger("0");
		char[] nums = Long.toString(num).toCharArray();
		int length = nums.length - 1;
		int digit = 0;

		while (digit < nums.length) {
			long temp = nums[digit] - '0';
			// System.out.println(digit+" "+temp+" "+num);

			for (int i = 1; i < temp; i++) {
				jaturi = jaturi.add(BigInteger.valueOf((long) (i * Math.pow(10, length - digit))));
//				System.out.println("ja1: " + BigInteger.valueOf((long) (i*Math.pow(10, length-digit))));
			}
			num = (long) (num - temp * Math.pow(10, length - digit));
//			System.out.println("num :"+ num);
			jaturi = jaturi.add(BigInteger.valueOf(temp * (num + 1)));
//			System.out.println("ja2: " +BigInteger.valueOf(temp*(num+1)));
			digit++;
//			System.out.println("jaturi " + jaturi);
		}
		// 본체 구하기
		BigInteger bonche = BigInteger.ZERO;
		int count = 0;
		for (int i = length; i >= 0; i--) {
			// System.out.println(num2);
			num2 = num2 / 10;
			bonche= bonche.add(BigInteger.valueOf((long) (45 * num2 * Math.pow(10, count))));
			count++;
			//System.out.println(count);
		}
		//System.out.println(bonche.longValue() + " " + jaturi.longValue());
		return jaturi.add(bonche);
	}
}
