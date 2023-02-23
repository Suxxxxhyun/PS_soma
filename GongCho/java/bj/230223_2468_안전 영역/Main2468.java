package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
public class Main2468 {

    static int n;
    static boolean[][] visited;
    static int ans = Integer.MIN_VALUE;
    static int[][] graph;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<=100; i++){
            int safed = 0;
            visited = new boolean[n][n];
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(graph[j][k] > i && !visited[j][k]){
                        dfs(j,k,i);
                        safed += 1;
                    }
                }
            }
            ans = Math.max(safed, ans);
        }
        if(ans == Integer.MIN_VALUE){
            ans = 0;
        }
        System.out.println(ans);
    }

    static void dfs(int x, int y, int high){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                continue;
            }

            if(visited[nx][ny]){
                continue;
            }

            if(!visited[nx][ny] && graph[nx][ny] > high){
                dfs(nx, ny, high);
            }
        }
    }

}
