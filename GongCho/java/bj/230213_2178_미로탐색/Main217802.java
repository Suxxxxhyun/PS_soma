package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main217802 {
	
	static int n,m;
	static StringTokenizer st;
	static int[][] graph;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Node{
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(x,y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}
				
				if(graph[nx][ny] == 1) {
					graph[nx][ny] = graph[x][y] + 1;
					q.offer(new Node(nx,ny));
				}
			}
		}
		
		System.out.println(graph[n-1][m-1]);
	}

}
