package Programmers;

public class Solution43162Test {

	public static void main(String[] args) {
		
		Solution43162 s = new Solution43162();
		int[][] computers = {{1, 1, 1, 0, 0}, {1, 1, 0, 0, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
		int n = 5;
		System.out.println(s.solution(n, computers));

	}

}
