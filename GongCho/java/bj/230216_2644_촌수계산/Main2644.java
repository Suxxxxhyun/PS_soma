package baekjun.DFSBFS;

//나와 나의 형제의 관계는 0촌일 것같은데.. -> 2촌이네
import java.io.*;
import java.util.*;

public class Main2644 {
	
	static int n,m,a,b,res;
	static StringTokenizer st;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		graph = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x].add(y);
			graph[y].add(x);
		}
		
		dfs(a,0);
		if(res == 0) {
			System.out.println(-1);
		} else {
			System.out.println(res);
		}
	}
	
	static void dfs(int start, int cnt) {
		
		if(start == b) {
			res = cnt;
			return;
		}
		
		visited[start] = true;
		
		for(int i=0; i<graph[start].size(); i++) {
			if(!visited[graph[start].get(i)]) {
				dfs(graph[start].get(i), cnt + 1);
			}
		}
	}

}
