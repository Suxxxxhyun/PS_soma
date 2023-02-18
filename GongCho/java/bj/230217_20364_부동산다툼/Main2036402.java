package baekjun.Tree;

import java.io.*;
import java.util.*;

public class Main2036402 {
	
	static int n,q;
	static StringTokenizer st;
	static int[] duck;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		duck = new int[q];
		visited = new boolean[n + 1];
		for(int i=0; i<q; i++) {
			duck[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<q; i++) {
			findRoute(duck[i]);
		}
		System.out.println(sb);
	}
	
	static void findRoute(int num) {
		int idx = num;
		int ans = 0;
		while(idx != 0) {
			if(visited[idx]) {
				ans = idx;
				//break;
				
				//break를 해주면 안되는 이유
				//boj.20364그림과 같이 주어졌을때,
				//2번, 5번이 이미 점유된 상태에서 어떤 오리가 5번 땅을 원한다고 하자.
				//그럼 이 오리는 처음 본 땅이 2번이어야하는건데,
				//break를 해준다면, 5번에서 1번까지 거슬러올라가는것을 막아주고 5번에서 바로 점유된것을 확인하고
				//ans값에 5를 갱신해주기 때문에, 즉, 5번땅을 본것이 됨.
			}
			idx = idx / 2;
		}
		sb.append(ans).append('\n');
		if(ans == 0) {
			visited[num] = true;
		}
	}

}
