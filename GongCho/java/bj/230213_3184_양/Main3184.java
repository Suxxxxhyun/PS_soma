package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;
public class Main3184 {

    static int r,c,v,o,total_v, total_o;
    static char[][] graph;
    static boolean[][] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph = new char[r][c];
        visited = new boolean[r][c];
        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++){
                graph[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(dfs(i,j)){
                    if(v >= o && !(v == 0 && o == 0)){
                        total_v += v;
                    } else if(v < o && !(v == 0 && o == 0)){
                        total_o += o;
                    }
                    v = 0;
                    o = 0;
                }
            }
        }
        sb.append(total_o).append(" ").append(total_v);
        System.out.println(sb);

    }

    static boolean dfs(int x, int y){
        if(x < 0 || y < 0 || x >= r || y >= c){
            return false;
        }

        if(!visited[x][y] && graph[x][y] != '#'){
            visited[x][y] = true;
            if(graph[x][y] == 'v'){
                v += 1;
            } else if(graph[x][y] == 'o'){
                o += 1;
            }
            dfs(x-1,y);
            dfs(x+1, y);
            dfs(x,y-1);
            dfs(x,y+1);
            return true;
        }
        return false;
    }
}
