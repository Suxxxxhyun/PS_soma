package baekjun.Greedy;

//2 4
//8 8
//4 8
import java.io.*;
import java.util.*;

public class Main1931 {
	
	static int n;
	static int[][] lecture;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		lecture = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lecture[i][0] = start;
			lecture[i][1] = end;
		}
		
		Arrays.sort(lecture, (o1,o2) -> {
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});
		
		int cnt = 0, end = 0;
		for(int i=0; i<n; i++) {
			if(end <= lecture[i][0]) {
				end = lecture[i][1];
				cnt+=1;
			}
		}
		System.out.println(cnt);
	}

}
