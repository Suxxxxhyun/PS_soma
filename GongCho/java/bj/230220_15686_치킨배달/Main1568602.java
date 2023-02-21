package baekjun.BackTrack;

import java.io.*;
import java.util.*;

public class Main1568602 {
	
	static int n,m, ans = Integer.MAX_VALUE;
	static int[][] graph;
	static StringTokenizer st;
	static ArrayList<Node> chicken = new ArrayList<Node>();
	static ArrayList<Node> house = new ArrayList<Node>();
	static boolean[] chicken_visit; //�ش� ġŲ���� ������� true, ���� �ʾҴٸ� false�� ��Ÿ���� ���� �迭
	static class Node{
		int x,y;
		
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
		graph = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 1) {
					house.add(new Node(i,j));
				} else if(graph[i][j] == 2) {
					chicken.add(new Node(i,j));
				}
			}
		}
		chicken_visit = new boolean[chicken.size()];
		rec_func(0,0);
		System.out.println(ans);
	}
	
	static void rec_func(int idx, int selected_cnt) {
		if(selected_cnt == m) {
			int total = 0;
			for(int i=0; i<house.size(); i++) {
				int distance = Integer.MAX_VALUE;
				for(int j=0; j<chicken.size(); j++) {
					if(chicken_visit[j]) {
						int dist = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
						distance = Math.min(distance,dist);
					}
					//distance = Math.min(distance,dist);
				}
				total += distance;
			}
			ans = Math.min(total, ans);
			return;
		}
		
		
		for(int cand = idx; cand < chicken.size(); cand++) {
			if(!chicken_visit[cand]) {
				chicken_visit[cand] = true;
				rec_func(cand + 1, selected_cnt + 1);
				chicken_visit[cand] = false;
			}
		}
	}

}
