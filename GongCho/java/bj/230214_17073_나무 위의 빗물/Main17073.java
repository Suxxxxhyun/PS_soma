package baekjun.Tree;

import java.io.*;
import java.util.*;

public class Main17073 {
	
	static int n,w,u,v,cnt;
	static StringTokenizer st;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i=2; i<=n; i++) {
			if(graph[i].size() == 1) {
				cnt += 1;
			}
		}
		
		System.out.println((double)w / (double)cnt);
	}

}
