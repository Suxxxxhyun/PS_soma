package baekjun.BackTrack;

import java.util.*;
import java.io.*;

//탐색하고 나서 연산자를 모두 나열하는 경우가 아니라
//연산자를 얻으면서 결과도 미리 계산해주는 것으로 코드가 업그레이드됨.

public class Main1488804 {
	
	static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] a,operator;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		operator = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		pro(0, a[0]);
		System.out.println(max);
		System.out.println(min);

	}
	
	static void pro(int idx, int value) {
		if(idx == n-1) {
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		
		for(int cand=0; cand<4; cand++) {
			if(operator[cand] != 0) {
				operator[cand]--;
				pro(idx + 1, calculator(value, cand, a[idx+1]));
				operator[cand]++;
			}
		}
	}
	
	static int calculator(int operand1, int operator, int operand2) {
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
