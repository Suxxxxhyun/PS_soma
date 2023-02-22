package baekjun.src.baekjun.DivideAndConquer;

import java.io.*;
import java.util.*;

/*
1. 시작점을 기준으로 현재 색종이에 대해 모두 같은 색상인지 체크한다.
2. 색상이 같다면, 색상의 개수를 1증가시키고 함수를 종료한다.
3. 색상이 같지 않다면, 4등분하여 각 부분 문제로 쪼개어 문제를 푼다.
 */
public class Main2630 {
    // 색상 카운트 할 변수 및 색종이(board)
    static int white = 0;
    static int blue = 0;
    static int[][] board;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //(0,0)시작점에서 현재 파티션에 대해 모두 같은 색상인지 체크하기 위한 메서드
        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);

    }

    public static void partition(int row, int col, int size) {

        if(colorCheck(row, col, size)) {
            if(board[row][col] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;	// 절반 사이즈
        // 재귀 호출
        partition(row, col, newSize);						// 2사분면
        partition(row, col + newSize, newSize);				// 1사분면
        partition(row + newSize, col, newSize);				// 3사분면
        partition(row + newSize, col + newSize, newSize);	// 4사분면
    }


    // 현재 파티션의 컬러가 같은지 체크한다.
    public static boolean colorCheck(int row, int col, int size) {

        int color = board[row][col];	// 첫 번째 원소를 기준으로 검사

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                // 색상이 같이 않다면 false를 리턴
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        // 검사가 모두 통과했다는 의미이므로 true 리턴
        return true;
    }
}
