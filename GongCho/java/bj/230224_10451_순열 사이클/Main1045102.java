package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main1045102 {
	
	static int t,n;
	static int[] a;
	static StringTokenizer st;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			a = new int[n+1];
			visited = new boolean[n+1];
			int cnt = 0;
			for(int j=1; j<=n; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			for(int k=1; k<=n; k++) {
				if(!visited[k]) {
					dfs(k);
					cnt += 1;
				}
				//System.out.println(cnt);
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		
		if(!visited[a[start]]) {
			dfs(a[start]);
		} else {
			return;
		}
	}

}
