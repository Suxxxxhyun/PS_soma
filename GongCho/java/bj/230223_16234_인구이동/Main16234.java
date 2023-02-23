package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main16234 {
	
	static StringTokenizer st;
	static int n,l,r;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static ArrayList<Node> list; //방문한 노드의 좌표를 담는 변수
	
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
		board = new int[n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(move());
	}
	
	static int move() {
		int result = 0;
		while(true) {
			boolean isMove = false;
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j]) {
						int sum = bfs(i,j);
						//방문한 곳이 두군데 이상이어야, 방문한 곳끼리 인구이동이 가능함.
						if(list.size() > 1) {
							changePopulation(sum);
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
	
	static void changePopulation(int sum) {
		int avg = sum / list.size();
		for(Node n : list) {
			board[n.x][n.y] = avg;
		}
	}
	
	static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		list = new ArrayList<>();
		
		q.offer(new Node(x,y));
		list.add(new Node(x,y));
		visited[x][y] = true;
		
		int sum = board[x][y];
		while(!q.isEmpty()) {
			Node current = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
					int diff = Math.abs(board[current.x][current.y] - board[nx][ny]);
					if(l <= diff && diff <= r) {
						q.offer(new Node(nx, ny));
						list.add(new Node(nx,ny));
						sum += board[nx][ny];
						visited[nx][ny] = true;
					}
				}	
			}
		}
		return sum;
	}

}
