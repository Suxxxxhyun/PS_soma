package baekjun.DFSBFS;

import java.io.*;
import java.util.*;

public class Main2667 {
	
	static int n, cnt, houses;
	static int[][] graph;
	static ArrayList<Integer> h = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(dfs(i,j)) {
					cnt += 1;
					h.add(houses);
					houses = 0;
				}
			}
		}
		sb.append(cnt).append('\n');
		Collections.sort(h);
		for(int i=0; i<h.size(); i++) {
			sb.append(h.get(i)).append('\n');
		}
		System.out.println(sb);
	}
	
	static boolean dfs(int x, int y) {
		
		if(x < 0 || y < 0 || x >= n || y >= n) {
			return false;
		}
		
		if(graph[x][y] == 1) {
			houses += 1;
			graph[x][y] = 0;
			dfs(x-1,y);
			dfs(x+1,y);
			dfs(x,y-1);
			dfs(x,y+1);
			return true;
		} else {
			return false;
		}
	}

}
