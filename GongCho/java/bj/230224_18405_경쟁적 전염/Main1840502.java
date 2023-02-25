package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main1840502 {
	
	static int n,k,s,x,y;
	static int[][] graph;
	static StringTokenizer st;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;
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
		k = Integer.parseInt(st.nextToken());
		graph = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		if(graph[x-1][y-1] != 0) {
			System.out.println(graph[x-1][y-1]);
		} else {
			visited = new boolean[n][n];
			for(int i=1; i<=s; i++) {
				for(int j=1; j<=k; j++) {
					if(graph[x-1][y-1] != 0) {
						break;
					}
					bfs(j);
				}
			}
			System.out.println(graph[x-1][y-1]);
		}
	}
	
	static void bfs(int virus) {
		Queue<Node> q = new LinkedList<Node>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(graph[i][j] == virus) {
					visited[i][j] = true;
					q.offer(new Node(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if(visited[nx][ny]) {
					continue;
				}
				
				if(!visited[nx][ny] && graph[nx][ny] == 0) {
					visited[nx][ny] = true;
					graph[nx][ny] = virus;
				}
			}
		}
	}

}
