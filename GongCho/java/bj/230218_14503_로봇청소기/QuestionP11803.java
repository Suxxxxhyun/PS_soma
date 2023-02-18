package ThisCodingTest.Simulation;

import java.io.*;
import java.util.*;

public class QuestionP11803 {
	
	static int n,m,a,b,direction;
	static StringTokenizer st;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		visited = new boolean[n][m];
		visited[a][b] = true;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pro();
	}
	
	static void turn_left() {
		direction -= 1;
		if(direction == -1) {
			direction = 3;
		}
	}
	
	static void pro() {
		int cnt = 1;
		int turn_time = 0;
		
		while(true) {
			turn_left();
			int nx = a + dx[direction];
			int ny = b + dy[direction];
			if(graph[nx][ny] == 0 && !visited[nx][ny]) {
				cnt += 1;
				turn_time = 0;
				visited[nx][ny] = true;
				a = nx;
				b = ny;
				continue;
			} else {
				turn_time += 1;
			}
			
			if(turn_time == 4) {
				nx = a - dx[direction];
				ny = b - dy[direction];
				
				if(graph[nx][ny] == 0) {
					//visited[nx][ny] = true;
					a = nx;
					b = ny;
					turn_time = 0;
				} else break;
			}
		}
		System.out.println(cnt);
	}

}
