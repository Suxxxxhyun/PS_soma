package baekjun.DFSBFS;

//�ð����⵵ : 64C3(���� ���� ����� ��) + ��������Ʈ(DFS�� BFS��) -> O(V+E) => O(64+64*4)
//Ȯ���Ű�� �� -> multisource bfs�ε� Ǯ��� dfs�ε� Ǯ���
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
	
	//���̷����� Ȯ���Ű�� ��
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
