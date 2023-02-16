package baekjun.BackTrack;

//연산자를 중간에 계산되는 식의 결과 및 최종 결과가 -10억과 10억사이의 값이므로, 연산자를 나열한뒤 계산한 값은 int범위(-21억~21억)로 충분함.
//수의 개수가 11개일때, 연산자는 10개 가능하고, 이 10개를 나열하는 경우와 같으므로, 10!이라고 생각함.(시간복잡도) -> 정답
//또, 이것은 순서를 고려하여 중복을 허용하지 않는 경우에 해당

//연산자를 미리 나열하는경우
import java.io.*;
import java.util.*;

public class Main1488803 {
	
	static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] a,operator,selected;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		operator = new int[4];
		selected = new int[n-1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		pro(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void pro(int idx) {
		if(idx == n-1) {
			int value = calculator();
			max = Math.max(max, value);
			min = Math.min(min, value);
			return;
		}
		
		for(int cand=0; cand<4; cand++) {
			if(operator[cand] != 0) {
				selected[idx] = cand;
				operator[cand]--;
				pro(idx + 1);
				operator[cand]++;
			}
		}
	}
	
	static int calculator() {
		int value = a[0];
		for(int i=1; i<=n-1; i++) {
			if(selected[i-1] == 0) {
				value = value + a[i];
			} else if(selected[i-1] == 1) {
				value = value - a[i];
			} else if(selected[i-1] == 2) {
				value = value * a[i];
			} else {
				value = value / a[i];
			}
		}
		return value;
	}

}
