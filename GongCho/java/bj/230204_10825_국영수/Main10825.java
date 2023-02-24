package baekjun.sort;

import java.io.*;
import java.util.*;

public class Main10825 {
	
	static int n;
	static student[] stu;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static class student implements Comparable<student>{
		int kor, eng, math;
		String name;
		
		public student(String name ,int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		public int compareTo(student other) {
			if(this.kor == other.kor) {
				if(this.eng == other.eng) {
					if(this.math == other.math) {
						return this.name.compareTo(other.name);
					}
					return other.math - this.math;
				}
				return this.eng - other.eng;
			}
			return other.kor - this.kor;
		}
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stu = new student[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			stu[i] = new student(name,kor,eng,math);
		}
		
		Arrays.sort(stu);
		
		for(int i=0; i<stu.length; i++) {
			sb.append(stu[i].name).append('\n');
		}
		System.out.println(sb);
	}

}
