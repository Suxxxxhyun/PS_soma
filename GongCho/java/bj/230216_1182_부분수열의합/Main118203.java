package baekjun.BackTrack;

import java.io.*;
import java.util.*;
//두수를 더하는 최대치는 2백만과 -2백만 사이의 값이므로 int에 담아도 됨.
//n=20일때의 모든 경우의 수가 곧 시간복잡도일텐데, 모든 경우의 수는 어떻게 생각하지?

public class Main118203 {
	
	static StringTokenizer st;
	static int n,s,cnt;
	static int[] a;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		a = new int[n];
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
		
		//포함하는경우
		pro(idx + 1,a[idx] + sum);
		//포함하지 않는 경우
		pro(idx + 1, sum);
	}

}
