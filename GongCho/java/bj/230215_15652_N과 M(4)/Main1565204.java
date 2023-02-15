package baekjun.BackTrack;

//n과 m의 최댓값이 8이므로,
//조건을 만족해야하는 모든 경우는 대략 8의 8제곱(물론, 비내림차순인 경우는 고려하지않음)
//8의 8제곱이 1억보다는 작은 값이므로, 1초안에 충분히 풀 수 있음.

import java.io.*;
import java.util.*;

public class Main1565204 {
	
	static StringTokenizer st;
	static int n,m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		selected = new int[m];
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
		
		int start;
		if(idx == 0) {
			start = 1;
		} else {
			start = selected[idx - 1];
		}
		
		for(int cand = start; cand <= n; cand++) {
			selected[idx] = cand;
			pro(idx + 1);
		}
	}

}
