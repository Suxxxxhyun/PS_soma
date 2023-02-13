package baekjun.DFSBFS;

//bfs, dfs모두 인접행렬로 구현했을때의 시간복잡도 : o(n^2)
//bfs, dfs모두 인접리스트로 구현했을때의 시간복잡도 : o(n+e)

//n의 최댓값이 천이므로, o(n^2), o(n+e) 모두 2초내에 풀 수 있으므로, 구현할 가치가 생김.
//인접리스트로 구하는 것이 어쨌든 더 효과적이니까, 인접리스트로 구현할 것임.

//정점번호가 작은것부터 방문해줘야하기때문에, 인접리스트를 정렬해줘야하는데,
//ArrayList<ArrayList<Integer>>에서 내부ArrayList<Integer>를 정렬해주기위해
//마지막 정점번호까지 접근하여 Collections.sort(graph.get(i))로 정렬해준다.
import java.io.*;
import java.util.*;

public class Main126002 {
	
	static int n,m,v;
	static StringTokenizer st;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		for(int i=0; i<=n; i++) {
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
		
		//System.out.println(graph);
		
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
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			sb.append(node).append(' ');
			
			for(int i=0; i<graph.get(node).size(); i++) {
				if(!visited[graph.get(node).get(i)]) {
					visited[graph.get(node).get(i)] = true;
					q.offer(graph.get(node).get(i));
				}
			}
		}
	}

}
