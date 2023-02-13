package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
public class Main4963 {

    static StringTokenizer st;
    static int[][] graph;
    static boolean[][] visited;
    static int cnt, h, w;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                break;
            }
            graph = new int[h][w];
            visited = new boolean[h][w];
            cnt = 0;
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<w; j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(dfs(i,j)){
                        cnt += 1;
                    }
                }
            }
            sb.append(cnt).append('\n');

        }
        System.out.println(sb);
    }

    static boolean dfs(int x, int y){

        if(x < 0 || y < 0 || x >= h || y >= w){
            return false;
        }

        if(graph[x][y] == 0 || visited[x][y]){
            return false;
        } else {
            visited[x][y] = true;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            dfs(x - 1, y - 1);
            dfs(x - 1, y + 1);
            dfs(x + 1, y - 1);
            dfs(x + 1, y + 1);
            return true;
        }
    }
}
