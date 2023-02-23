package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main1623403 {
	
	static StringTokenizer st;
	static int n,l,r;
	static int[][] graph;
	static boolean[][] visited;
	static ArrayList<Node> list;
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
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
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		graph = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(move());
	}
	
	static int move() {
		int result = 0;
		while(true) {
			boolean isMove = false;
			visited = new boolean[n][n]; //왜 여기에 생성해야할까
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]) {
						int sum = bfs(i,j);
						if(list.size() > 1) {
							change(sum);
							isMove = true;
						}
					}
				}
			}
			if(!isMove) {
				return result;
			}
			result++;
		}
	}
	
	static void change(int sum) {
		int avg = sum / list.size();
		for(Node n : list) {
			graph[n.x][n.y] = avg;
		}
	}
	
	static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		list = new ArrayList<Node>();
		visited[x][y] = true;
		list.add(new Node(x,y));
		q.offer(new Node(x,y));
		int sum = graph[x][y];
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = current.x + dir[i][0];
				int ny = current.y + dir[i][1];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) {
					continue;
				}
				
				if(visited[nx][ny]) {
					continue;
				}
				
				if(!visited[nx][ny]) {
					int diff = Math.abs(graph[current.x][current.y] - graph[nx][ny]);
					if(diff >= l && diff <= r) {
						q.offer(new Node(nx,ny));
						visited[nx][ny] = true;
						list.add(new Node(nx,ny));
						sum += graph[nx][ny];
					}
					
				}
			}
		}
		return sum;
	}

}
