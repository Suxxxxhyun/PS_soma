package baekjun.DFSBFS;

//시간복잡도 : 64C3(벽을 고르는 경우의 수) + 인접리스트(DFS든 BFS든) -> O(V+E) => O(64+64*4)
//확산시키는 거 -> multisource bfs로도 풀어보고 dfs로도 풀어보기
import java.io.*;
import java.util.*;

public class Main1450203 {
	
	static int n,m,b,ans = Integer.MIN_VALUE;
	static int[][] graph, blank;
	static boolean[][] visited;
	static StringTokenizer st;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n+1][m+1];
		blank = new int[n*m + 1][2];
		visited = new boolean[n+1][m+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pro();
	}
	
	//안전영역(최대 64)의 크기에서 벽을 하나씩 고르게 되었을때의 좌표를 blank배열에 담아주자.
	static void pro() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(graph[i][j] == 0) {
					b++;
					blank[b][0] = i;
					blank[b][1] = j;
				}
			}
		}
		
		//blank배열에서 벽을 최대 3개고르는 메서드
		dfs(1,0);
		System.out.println(ans);
	}
	
	//1번째에서부터 벽을 고를 수 있는데, 1번째 벽을 고르는 경우와 고르지 않는 경우로 나눌 수 있다.
	static void dfs(int idx, int selected_cnt) {
		if(selected_cnt == 3) {
			bfs();
			return;
		}
		
		if(idx > b) {
			return;
		}
		
		graph[blank[idx][0]][blank[idx][1]] = 1;
		dfs(idx + 1, selected_cnt + 1);
		graph[blank[idx][0]][blank[idx][1]] = 0;
		dfs(idx + 1, selected_cnt);
	}
	
	//바이러스를 확산시키는 곳
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				visited[i][j] = false;
				if(graph[i][j] == 2) {
					visited[i][j] = true;
					q.offer(i);
					q.offer(j);
				}
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.poll(), y = q.poll();
			
			for(int k=0; k<4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				
				if(nx < 1 || ny < 1 || nx > n || ny > m) {
					continue;
				}
				
				if(graph[nx][ny] == 1) {
					continue;
				}
				
				if(!visited[nx][ny] && graph[nx][ny] == 0) {
					visited[nx][ny] = true;
					q.offer(nx);
					q.offer(ny);
				}
			}
		}
		
		int cnt = 0;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(!visited[i][j] && graph[i][j] == 0) {
					cnt+=1;
				}
			}
		}
		ans = Math.max(cnt, ans);
	}

}
