package baekjun.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1450204 {

	static int n,m,b,ans = Integer.MIN_VALUE;
	static int[][] graph, graph_A , blank;
	static boolean[][] visited;
	static StringTokenizer st;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n+1][m+1];
		graph_A = new int[n+1][m+1];
		blank = new int[n*m + 1][2];
		visited = new boolean[n+1][m+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=m; j++) {
				int a = Integer.parseInt(st.nextToken());
				graph[i][j] = a;
				graph_A[i][j] = a;
			}
		}
		
		pro();
	}
	
	//��������(�ִ� 64)�� ũ�⿡�� ���� �ϳ��� ���� �Ǿ������� ��ǥ�� blank�迭�� �������.
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
		
		//blank�迭���� ���� �ִ� 3������ �޼���
		dfs(1,0);
		System.out.println(ans);
	}
	
	//1��°�������� ���� �� �� �ִµ�, 1��° ���� ���� ���� ���� �ʴ� ���� ���� �� �ִ�.
	static void dfs(int idx, int selected_cnt) {
		if(selected_cnt == 3) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					if(graph_A[i][j] == 2 && !visited[i][j]) {
						extend_dfs(i,j);
					}
				}
			}
			//���������� ���� ���ϱ�
			count();
			return;
		}
		
		if(idx > b) {
			return;
		}
		
		graph_A[blank[idx][0]][blank[idx][1]] = 1;
		dfs(idx + 1, selected_cnt + 1);
		graph_A[blank[idx][0]][blank[idx][1]] = 0;
		dfs(idx + 1, selected_cnt);
	}
	
	static void extend_dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int k=0; k<4; k++) {
			int nx = x + dir[k][0];
			int ny = y + dir[k][1];
			
			if(nx < 1 || ny < 1 || nx > n || ny > m) {
				continue;
			}
			
			if(graph_A[x][y] == 1) {
				continue;
			}
			
			if(graph_A[x][y] == 2 && !visited[nx][ny] && graph_A[nx][ny] == 0) {
				visited[nx][ny] = true;
				graph_A[nx][ny] = 2;
				extend_dfs(nx,ny);
			}
		}
	}
	
	static void count() {
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(graph_A[i][j] == 0) {
					cnt += 1;
				}
			}
		}
		
		ans = Math.max(cnt, ans);
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(visited[i][j]) {
					graph_A[i][j] = graph[i][j];
				}
			}
		}
		
		visited = new boolean[n+1][m+1];
	}

}
