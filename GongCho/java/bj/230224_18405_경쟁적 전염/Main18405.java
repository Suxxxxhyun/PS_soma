package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main18405 {
	
	static int n,k,s,x,y;
	static StringTokenizer st;
	static int[][] graph;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static StringBuilder sb = new StringBuilder();
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
			sb.append(graph[x-1][y-1]);
		} else {
			for(int t=0; t<s; t++) {
				for(int i=1; i<=k; i++) {
					if(graph[x-1][y-1] != 0) {
						break;
					}
					bfs(i);
				}
			}
			sb.append(graph[x-1][y-1]);
		}
		System.out.println(sb);
	}
	
	static void bfs(int virus_no) {
		//해당 바이러스가 있는 곳을 큐에 삽입한다.
		Queue<Node> q = new LinkedList<Node>();
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				if(virus_no == graph[r][c]) {
					q.offer(new Node(r,c));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			for(int i=0; i<4; i++) {
				int nx = node.x + dir[i][0];
				int ny = node.y + dir[i][1];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if(graph[nx][ny] != 0) {
					continue;
				}
				
				if(graph[nx][ny] == 0) {
					graph[nx][ny] = virus_no;
				}
			}
		}
	}

}
