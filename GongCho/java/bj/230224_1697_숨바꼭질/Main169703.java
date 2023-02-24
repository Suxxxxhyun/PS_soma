package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main169703 {
	
	static StringTokenizer st;
	static int n,k;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if(n == k) {
			System.out.println(0);
		} else {
			bfs();
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			int next;
			for(int i=0; i<3; i++) {
				if(i == 0) {
					next = x - 1;
				} else if(i == 1) {
					next = x + 1;
				} else {
					next = 2 * x;
				}
				
				if(next < 0 || next > 100000 || visited[next] != 0) {
					continue;
				}
				
				visited[next] = visited[x] + 1;
				if(next == k) {
					System.out.println(visited[next]);
					break;
				}
				q.offer(next);
			}
		}
	}

}
