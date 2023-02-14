package baekjun.src.baekjun.Tree;

import java.io.*;
import java.util.*;
public class Main11725 {

    static int n;
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        parent = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        bfs(1);
        output();
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int x = q.poll();

            for(int i=0; i<graph[x].size(); i++){
                if(!visited[graph[x].get(i)]){
                    visited[graph[x].get(i)] = true;
                    parent[graph[x].get(i)] = x;
                    q.offer(graph[x].get(i));
                }
            }
        }
    }

    static void output(){
        for(int i=2; i<parent.length; i++){
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }
}
