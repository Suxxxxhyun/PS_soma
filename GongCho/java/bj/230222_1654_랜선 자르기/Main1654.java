package baekjun.BinarySearch;

import java.io.*;
import java.util.*;

public class Main1654 {
	
	static StringTokenizer st;
	static int k,n;
	static int[] len;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		len = new int[k];
		for(int i=0; i<k; i++) {
			len[i] = Integer.parseInt(br.readLine());
		}
		
		pro();
	}
	
	static void pro() {
		long L = 1, R = Integer.MAX_VALUE;
		long ans = 0;
		
		while(L <= R) {
			long mid = (L + R) / 2;
			if(determination(mid)) {
				L = mid + 1;
				ans = mid;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(ans);
	}
	
	static boolean determination(long x) {
		
		int cnt = 0;
		
		for(int i=0; i<k; i++) {
			if(x > len[i]) {
				continue;
			}
			cnt += (len[i] / x);
		}
		
		return cnt >= n;
	}

}
