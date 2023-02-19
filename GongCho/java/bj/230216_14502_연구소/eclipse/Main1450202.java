package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

//4:35 ~ 5:00 > 조합만 먼저 해볼것
public class Main1450202 {
	
	static StringTokenizer st;
	static int n,m,B,ans;
	static int[][] A, blank;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		A = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		blank = new int[n*m + 1][2];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=m; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pro();
	}
	
	static void pro() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(A[i][j] == 0) {
					B++;
					blank[B][0] = i;
					blank[B][1] = j;
				}
			}
		}
		dfs(1,0);
		System.out.println(ans);
	}
	
	static void dfs(int idx, int selected_cnt) {
		if(selected_cnt == 3) {
			bfs();
			return;
		}
		
		if(idx > B) {
			return;
		}
		
		A[blank[idx][0]][blank[idx][1]] = 1;
		dfs(idx + 1, selected_cnt + 1);
		A[blank[idx][0]][blank[idx][1]] = 0;
		dfs(idx + 1, selected_cnt);
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				visited[i][j] = false;
				if(A[i][j] == 2) {
					q.offer(i);
					q.offer(j);
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			for(int k=0; k<4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				
				if(nx < 1 || ny < 1 || nx > n || ny > m) {
					continue;
				}
				
				if(visited[nx][ny]) {
					continue;
				}
				
				if(!visited[nx][ny] && A[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.offer(nx);
					q.offer(ny);
				}
			}
		}
		
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(!visited[i][j] && A[i][j] == 0) {
					cnt += 1;
				}
			}
		}
		ans = Math.max(ans, cnt);
	}

}
