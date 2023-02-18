package baekjun.Tree;

import java.io.*;
import java.util.*;

public class Main2036402 {
	
	static int n,q;
	static StringTokenizer st;
	static int[] duck;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		duck = new int[q];
		visited = new boolean[n + 1];
		for(int i=0; i<q; i++) {
			duck[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<q; i++) {
			findRoute(duck[i]);
		}
		System.out.println(sb);
	}
	
	static void findRoute(int num) {
		int idx = num;
		int ans = 0;
		while(idx != 0) {
			if(visited[idx]) {
				ans = idx;
				//break;
			}
			idx = idx / 2;
		}
		sb.append(ans).append('\n');
		if(ans == 0) {
			visited[num] = true;
		}
	}

}
