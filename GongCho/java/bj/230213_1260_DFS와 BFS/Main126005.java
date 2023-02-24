package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main126005 {
	
	static int n,m,v;
	static boolean[] visited;
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(graph.get(i));
		}
		
		dfs(v);
		sb.append('\n');
		visited = new boolean[n+1];
		bfs(v);
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(' ');
		
		for(int i=0; i<graph.get(start).size(); i++) {
			if(!visited[graph.get(start).get(i)]) {
				dfs(graph.get(start).get(i));
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append(x).append(' ');
			
			for(int i=0; i<graph.get(x).size(); i++) {
				if(!visited[graph.get(x).get(i)]) {
					visited[graph.get(x).get(i)] = true;
					q.offer(graph.get(x).get(i));
				}
			}
		}
	}

}
