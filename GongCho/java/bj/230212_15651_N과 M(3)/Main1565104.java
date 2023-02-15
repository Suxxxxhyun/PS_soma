package baekjun.BackTrack;

//시간복잡도 : m과 n의 최댓값이 7이기때문에, 
//m, n이 모두 7일경우, 
//7까지의 자연수 중에서 7개를 모두 고른 수열 -> 이때, 순서도 고려해야하기때문에,
//최악의 경우는 7 * 7 * ... -> 7의 7제곱으로 시간복잡도를 생각할 수 있음.

import java.io.*;
import java.util.*;

public class Main1565104 {
	
	static StringTokenizer st;
	static int n,m;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
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
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int cand = 1; cand <= n; cand++) {
			selected[idx] = cand;
			pro(idx + 1);
		}
	}

}
