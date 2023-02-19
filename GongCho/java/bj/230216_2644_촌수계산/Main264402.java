package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main264402 {
	
	static StringTokenizer st;
	static int n,a,b,m, res = -1;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=0; i<=n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		pro(a,b,0);
		System.out.println(res);
		
	}
	
	static void pro(int start, int end, int cnt) {
		if(start == end) {
			res = cnt;
			return;
		}
		
		visited[start] = true;
		
		for(int i=0; i<graph[start].size(); i++) {
			if(!visited[graph[start].get(i)]) {
				pro(graph[start].get(i), end, cnt + 1);
			}
		}
	}

}
