package ThisCodingTest.Simulation;

import java.io.*;
import java.util.*;

public class QuestionP11802 {
	
	static int n,m,direction,a,b;
	static StringTokenizer st;
	//방문한 위치를 저장하기 위한 맵을 생성하여 0으로 초기화
	static int[][] visited = new int[50][50];
	static int[][] graph = new int[50][50];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static void turn_left() {
		direction -= 1;
		if(direction == -1) {
			direction = 3;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());
		visited[a][b] = 1;
		
		//그래프 정보 입력받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pro();
	}
	
	static void pro() {
		int cnt = 1;
		int turn_time = 0;
		while(true) {
			//왼쪽으로 회전
			turn_left();
			int nx = a + dx[direction];
			int ny = b + dy[direction];
			//회전한 이후 정면에 가보지 않은 존재하는 경우 이동
			if(visited[nx][ny] == 0 && graph[nx][ny] == 0) {
				visited[nx][ny] = 1;
				a = nx;
				b = ny;
				cnt += 1;
				turn_time = 0;
				continue;
			}
			//회전한 이후 정면에 가보지 않은 칸이 없거나 바다인경우
			else turn_time += 1;
			
			//네 방향 모두 갈 수 없는 경우
			if(turn_time == 4) {
				nx = a - dx[direction];
				ny = b - dy[direction];
				//뒤로 갈 수 있다면 이동하기
				if(graph[nx][ny] == 0) {
					a = nx;
					b = ny;
					turn_time = 0;
				} 
				//뒤가 바다로 막혀있는 경우
				else break;
			}
		}
		System.out.println(cnt);
	}

}
