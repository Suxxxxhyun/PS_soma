package baekjun.Greedy;

import java.io.*;
import java.util.*;

public class Main1715 {
	
	static int n, ans;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		pro();
		System.out.println(ans);
	}
	
	static void pro() {
		if(pq.size() > 1) {
			int temp1 = pq.poll();
			int temp2 = pq.poll();
			int num = temp1 + temp2;
			ans += num;
			
			pq.offer(num);
			pro();
		}
		
	}

}
