package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
//구현 실패
//https://wiselog.tistory.com/119 블로그 참조
public class Main16926 {

    static int n,m,r;
    static int[][] a;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
        output();
    }

    static void pro(){
        int count = Math.min(n,m) / 2; //돌아가는 라인의 수
        for(int i=0; i<r; i++){
            for(int j=0; j<count; j++){ //라인들 전부 돌리기
                int temp = a[j][j]; //맨 마지막에 넣기 위해 따로 저장

                for(int k=j+1; k<m-j; k++){ //1 2 3 4 -> 2 3 4
                    a[j][k-1] = a[j][k];
                }

                for(int k=j+1; k<n-j; k++){ //8 12 16
                    a[k-1][m-1-j] = a[k][m-1-j];
                }

                for(int k=m-2-j; k>=j; k--) { //13 14 15
                    a[n-1-j][k+1] = a[m-1-j][k];
                }

                for(int k=n-2-j; k>=j; k--) {
                    a[k+1][j] = a[k][j]; //1 5 9
                }

                a[j+1][j] = temp;
            }
        }
    }

    static void output(){
        for(int j=0; j<n; j++) {
            for(int k=0; k<m; k++) {
                System.out.print(a[j][k] + " ");
            }
            System.out.println();
        }
    }
}
