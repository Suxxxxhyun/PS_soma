package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;

public class Main2606 {

    static int node, edge, cnt;
    static boolean[] visited;
    static StringTokenizer st;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        visited = new boolean[node+1];
        for(int i=0; i<=node; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=1; i<=edge; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);
        System.out.println(cnt-1);
    }

    static void dfs(int start){
        visited[start] = true;
        cnt += 1;

        for(int i=0; i<graph.get(start).size(); i++){
            if(!visited[graph.get(start).get(i)]){
                dfs(graph.get(start).get(i));
            }
        }
    }
}
