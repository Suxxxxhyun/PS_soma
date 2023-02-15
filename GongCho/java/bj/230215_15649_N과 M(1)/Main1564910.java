package baekjun.BackTrack;

import java.io.*;
import java.util.*;

//시간복잡도 : n과 m의 최댓값이 8이므로, 8! = 약 4만가지이므로,
//모든 경우의수가 4만가지이고, 모든 경우의 수를 구하는 것 자체가 시간복잡도이니, 
//따라서 총 시간복잡도는 4만가지로 정리할 수 있음.

public class Main1564910 {
	
	static int n,m;
	static StringTokenizer st;
	static int[] selected, isUsed;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m];
		isUsed = new int[n+1];
		pro(0);
		System.out.println(sb);
		
	}
	
	static void pro(int idx) {
		if(idx == m) {
			for(int i=0; i<m; i++) {
				sb.append(selected[i] + " ");
			}
			sb.append('\n');
			return;
		}
		
		for(int cand = 1; cand <= n; cand++) {
			if(isUsed[cand] == 0) {
				selected[idx] = cand;
				isUsed[cand] = 1;
				pro(idx + 1);
				isUsed[cand] = 0;
			}
		}
	}

}
