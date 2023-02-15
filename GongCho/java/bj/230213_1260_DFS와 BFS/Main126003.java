package baekjun.DFSBFS;

//bfs든 bfs든, 
//모두 인접리스트로 구현하느냐, 인접행렬로 구현하느냐에 따라서 시간복잡도가 달라지는데,
//인접리스트로 구현했을때의 시간복잡도는 o(v+e)
//인접행렬로 구현했을때의 시간복잡도는 o(v^2)이다.
//지금 문제에서는 인접리스트든, 인접행렬이든 모두 풀 수 있지만,
//정점의 개수의 최댓값이 천, 간선의 개수의 최댓값이 만이라고 할때
//인접리스트의 시간복잡도가 더 낮으므로(효과적이므로), 인접리스트로 구현한다.
//인접리스트는 일반적으로 ArrayList<ArrayList<Integer>>방식을 사용해왔지만,
//이번에는 ArrayList<Integer>[]로 구현해보겠다.

import java.io.*;
import java.util.*;

public class Main126003 {
	
	static int n,m,v;
	static StringTokenizer st;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<n+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(v);
		sb.append('\n');
		visited = new boolean[n+1];
		bfs(v);
		System.out.println(sb);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		sb.append(start).append(" ");
		
		for(int i=0; i<graph[start].size(); i++) {
			if(!visited[graph[start].get(i)]) {
				dfs(graph[start].get(i));
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append(x).append(' ');
			
			for(int i=0; i<graph[x].size(); i++) {
				if(!visited[graph[x].get(i)]) {
					visited[graph[x].get(i)] = true;
					q.offer(graph[x].get(i));
				}
			}
		}
	}

}
