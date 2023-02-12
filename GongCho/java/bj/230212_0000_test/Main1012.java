package baekjun.src.baekjun.BFSDFS;

//테스트용///
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1012 {

    static int t,m,n,k,result = 0;
    static int[][] graph;
    static boolean[][] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            graph = new int[n][m];
            visited = new boolean[n][m];
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }
            for(int k=0; k<n; k++){
                for(int s=0; s<m; s++){
                    if(dfs(k,s)){
                        result += 1;
                    }
                }
            }
            sb.append(result).append('\n');
            result = 0;
        }
        System.out.println(sb);
    }

    static boolean dfs(int x, int y){
        if(x < 0 || y < 0 || x >= n || y >= m){
            return false;
        }

        if(!visited[x][y] && graph[x][y] == 1){
            visited[x][y] = true;
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
            return true;
        }
        return false;
    }
}
