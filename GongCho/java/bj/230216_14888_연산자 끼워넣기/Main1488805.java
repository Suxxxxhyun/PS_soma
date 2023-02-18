package baekjun.BackTrack;

import java.io.*;
import java.util.*;

public class Main1488805 {
	
	static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] a, operator;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		operator = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		pro(0,a[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void pro(int idx, int num) {
		if(idx == n) {
			min = Math.min(num, min);
			max = Math.max(num, max);
			return;
		}
		
		for(int cand = 0; cand < 4; cand++) {
			if(operator[cand] != 0) {
				operator[cand]--;
				pro(idx + 1, calculator(num, cand, a[idx + 1]));
				operator[cand]++;
			}
			
		}
	}
	
	static int calculator(int operand1, int operator ,int operand2) {
		if(operator == 0) {
			return operand1 + operand2;
		} else if(operator == 1) {
			return operand1 - operand2;
		} else if(operator == 2) {
			return operand1 * operand2;
		} else {
			return operand1 / operand2;
		}
	} 

}
