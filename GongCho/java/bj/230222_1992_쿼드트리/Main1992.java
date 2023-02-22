package baekjun.src.baekjun.DivideAndConquer;

import java.io.*;
public class Main1992 {

    static int n;
    static int[][] graph;
    static String result = "";
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        partition(0,0,n);
        System.out.println(sb);
    }

    static void partition(int row, int col, int size){
        if(isSame(row, col, size)){
            sb.append(graph[row][col]);
            return;
        }
        int newSize = size / 2;
        sb.append('(');
        partition(row,col, newSize);
        partition(row,col+newSize, newSize);
        partition(row+newSize,col, newSize);
        partition(row+newSize,col+newSize, newSize);
        sb.append(')');
    }

    static boolean isSame(int row, int col, int size){
        int dot = graph[row][col];

        for(int i=row; i<row + size; i++){
            for(int j=col; j<col+size; j++){
                if(graph[i][j] != dot){
                    return false;
                }
            }
        }
        return true;
    }
}
