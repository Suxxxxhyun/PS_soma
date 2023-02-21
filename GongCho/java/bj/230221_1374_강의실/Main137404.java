package baekjun.Greedy;

import java.io.*;
import java.util.*;

public class Main137404 {
	
	static int n,cnt;
	static StringTokenizer st;
	static lecture[] list;
	static PriorityQueue<lecture> pq = new PriorityQueue<lecture>((l1,l2)->{
		return l1.end - l2.end;
	});
	static class lecture implements Comparable<lecture>{
		int no, start, end;
		
		public lecture(int no, int start, int end) {
			this.no =  no;
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(lecture other) {
			if(this.start == other.start) {
				if(this.end == other.end) {
					return this.no - other.no;
				}
				return this.end - other.end;
			}
			return this.start - other.start;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new lecture[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int no = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[i] = new lecture(no, start, end);
		}
		
		Arrays.sort(list);
		pro();
	}
	
	static void pro() {
		pq.offer(list[0]);
		cnt += 1;
		
		if(list.length == 1) {
			System.out.println(cnt);
		} else {
			for(int i=1; i<n; i++) {
				lecture lec = pq.peek();
				if(lec.end > list[i].start) {
					pq.offer(list[i]);
					cnt+=1;
				} else {
					pq.poll();
					pq.offer(list[i]);
				}
			}
			System.out.println(cnt);
		}
	}

}
