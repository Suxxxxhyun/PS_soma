package baekjun.BackTrack;

import java.io.*;
import java.util.*;

public class Main118204 {
	
	static StringTokenizer st;
	static int[] a;
	static int n,s,cnt;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		a = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		pro(0,0);
		if(s == 0) {
			System.out.println(cnt - 1);
		} else {
			System.out.println(cnt);
		}

	}
	
	static void pro(int idx, int sum) {
		if(idx == n) {
			if(sum == s) {
				cnt += 1;
			}
			return;
		}
		
		//포함하지않는경우
		pro(idx + 1, sum);
		//포함하는경우
		pro(idx + 1, sum + a[idx]);
	}

}
