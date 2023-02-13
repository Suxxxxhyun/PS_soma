package baekjun.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main101202 {
	
	static int t, n, m, k, cnt;
	static StringTokenizer st;
	static int[][] graph;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
	
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			cnt = 0;
			graph = new int[n][m];
			visited = new boolean[n][m];
			for(int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[b][a] = 1;
			}
			
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < m; c++) {
					if(dfs(r,c)) {
						cnt += 1;
					}
				}
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
		
		
		
	}
	
	static boolean dfs(int x, int y) {
		
		if(x < 0 || y < 0 || x >= n || y >= m) {
			return false; 
		}
		
		if(!visited[x][y] && graph[x][y] == 1) {
			visited[x][y] = true;
			
			dfs(x-1, y);
			dfs(x+1, y);
			dfs(x, y-1);
			dfs(x, y+1);
			return true;
		}
		return false;
	}

}
