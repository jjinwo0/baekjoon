import java.util.*;
import java.io.*;

public class Solution{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int nums[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				nums[i]=Integer.parseInt(st.nextToken());
			}
			System.out.printf("#%d %d\n",t,lis(nums,N));
		}
	}

	public static int lis(int[] nums,int n) {
		int answer =0;
		int answers[] = new int[n];
		Arrays.fill(answers, Integer.MAX_VALUE);
		answers[0] = 0;
		for(int i=0;i<n;i++) {
			// 이분탐색으로 찾아서 해당위치 조지기
			int idx = binarysearch(answers,n,nums[i]);
			answers[idx]=nums[i];
		}
		for(int i=1;i<n;i++) {
			if(answers[i]==Integer.MAX_VALUE) break;
			answer++;
		}
		return answer;
	}

	public static int binarysearch(int[] answers, int n, int num) {
		int idx =-1;
		int start =0;
		int end = n-1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(num<=answers[mid]) {
				idx=mid;
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return idx;
	}
}
