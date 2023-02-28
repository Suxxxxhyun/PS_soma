package baekjun.Greedy;

import java.io.*;
import java.util.*;

public class Main171502 {
	
	static int n;
	static long ans;
	static PriorityQueue<Long> pq = new PriorityQueue<Long>();

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			pq.offer(Long.parseLong(br.readLine()));
		}
		pro();
		System.out.println(ans);
	}
	
	static void pro() {
		while(pq.size() > 1) {
			long temp1 = pq.poll();
			long temp2 = pq.poll();
			
			long num = temp1 + temp2;
			ans += num;
			pq.offer(num);
		}
		
	}

}

