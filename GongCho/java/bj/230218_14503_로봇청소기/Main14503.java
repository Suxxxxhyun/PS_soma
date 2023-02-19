package baekjun.src.baekjun.implement;

import java.io.*;
import java.util.*;
//이코테 part02. 구현의 게임개발 문제와 똑같음.
public class Main14503 {

    static int n,m,r,c,direction;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visited = new boolean[n][m];
        visited[r][c] = true;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pro();
    }

    static void turn_left(){
        direction -= 1;
        if(direction == -1){
            direction = 3;
        }
    }

    static void pro(){
        //로봇청소기가 있는 칸은 빈칸이라고 문제에 명시되어있다.
        //처음 로봇청소기가 있는 곳을 r,c로 주어지는데, 이때에도 빈칸이라는 의미를 지니고 있으므로,
        //처음 로봇청소기가 위치한 곳을 청소해주었다고 하기 위해 cnt를 1로 초기화한다.
        int cnt = 1;
        int turn_time = 0;
        while(true){
            turn_left();
            int nx = r + dx[direction];
            int ny = c + dy[direction];

            if(!visited[nx][ny] && graph[nx][ny] == 0){
                visited[nx][ny] = true;
                r = nx;
                c = ny;
                cnt += 1;
                turn_time = 0;
                continue;
            }
            //회전한 이후에 정면에 이미 방문한 칸이거나 청소한 경우
            else turn_time += 1;
            //네 방향 모두 갈 수 없는 경우
            if(turn_time == 4){
                nx = r - dx[direction];
                ny = c - dy[direction];
                if(graph[nx][ny] == 0){
                    r = nx;
                    c = ny;
                    turn_time = 0;
                }
                //뒤가 벽으로 막혀있는 경우
                else break;
            }
        }
        System.out.println(cnt);
    }
}
