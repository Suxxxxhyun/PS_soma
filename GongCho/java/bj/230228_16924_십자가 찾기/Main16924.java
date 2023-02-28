package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;

//½ÇÆÐ
public class Main16924 {

    static int n,m;
    static StringTokenizer st;
    static char[][] graph;
    static int[][] visit;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node> answer = new ArrayList<Node>();
    static class Node{
        int row, col, val;

        public Node(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j] = str.charAt(j);
            }
        }
        visit = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j] == '*'){
                    visit[i][j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j] == '*'){
                    int scale = check(i,j);
                    if(scale == 0){
                        continue;
                    }
                    for(int s = scale; s > 0; s--){
                        remove(i,j,s);
                        answer.add(new Node(i+1, j+1,s));
                    }
                }
            }
        }

        boolean isCan = true;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visit[i][j] == 1){
                    isCan = false;
                }
            }
        }

        if(isCan){
            sb.append(answer.size()).append('\n');
            for(int i=0; i<answer.size(); i++){
                sb.append(answer.get(i).row + " " + answer.get(i).col + " " + answer.get(i).val);
                sb.append('\n');
            }
            System.out.print(sb);
        } else {
            System.out.print(-1);
        }


    }

    static int check(int row, int col){
        int scale = 0;
        boolean Flag = false;
        while(true){
            for(int i=0; i<4; i++){
                int nx = (dir[i][0] * (scale + 1)) + row;
                int ny = (dir[i][1] * (scale + 1)) + col;
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || graph[nx][ny] != '*'){
                    Flag = true;
                    break;
                }
            }

            if (Flag){
                break;
            }
            scale += 1;
        }
        return scale;
    }

    static void remove(int row, int col, int s){
        visit[row][col] = 0;
        for(int i=0; i<4; i++){
            int x = dir[i][0];
            int y = dir[i][1];
            int nx = (x * s) + row;
            int ny = (y * s) + col;
            visit[nx][ny] = 0;
        }
    }
}

