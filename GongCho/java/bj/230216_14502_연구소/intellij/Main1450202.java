package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;

//호석님과 코드 다름.
//호석님코드에서 벽을 세우는 경우는 그대로 가져오고, 바이러스를 확산시키는 부분을 내가 기존에 생각한 DFS로 구현함.
public class Main1450202 {

    static int n,m,B,ans = 0;
    static StringTokenizer st;
    static int[][] A, A_,blank; //blank배열은 벽이 세워진 위치를 담기 위한 배열
    static boolean[][] visit;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n+1][m+1];
        A_ = new int[n+1][m+1];
        blank = new int[n * m + 1][2];
        visit = new boolean[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=m; j++){
                int a = Integer.parseInt(st.nextToken());
                A[i][j] = a;
                A_[i][j] = a;
            }
        }

        pro();
    }

    //빈 공간(0)에다가 벽을 다 넣어주기위한 메소드로, 원래 벽은 3개까지만 가능하지만, 그걸 고려하지 않고 있음.
    static void pro(){
        //모든 벽의 위치를 먼저 모아놓자. 이때, B는 벽의 개수를 세어주기 위한 변수임.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(A_[i][j] == 0){
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }
        //벽을 3개 세우는 모든 방법을 확인해보자.
        dfs(1,0);
        System.out.println(ans);
    }

    //idx번째 빈칸에 벽을 세울지 말지 결정해야하고, 이전까지 selected_cnt개의 벽을 세웠다.
    static void dfs(int idx, int selected_cnt){
        if(selected_cnt == 3){
            // extend_dfs메서드로 바이러스를 확산시켜보자.
            for(int i=1; i<=n; i++){
                for(int j=1; j<=m; j++){
                    if(A_[i][j] == 2 && !visit[i][j]){
                        extend_dfs(i,j);
                    }
                }
            }
            count();
            return;
        }

        //더이상 세울 수 있는 벽이 없는 상태
        if(idx > B){
            return;
        }

        A_[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1); //선택한 벽을 포함하는 경우
        A_[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt); //선택한 벽을 포함하지 않는 경우
    }

    //dfs메서드의 파라미터(x,y)는 시작좌표를 의미함.
    static boolean extend_dfs(int x, int y){

        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx <= 0 || ny <= 0 || nx > n || ny > m){
                continue;
            }

            if(A_[nx][ny] == 1){
                continue;
            }

            if(A_[nx][ny] == 0 && !visit[nx][ny] && A_[x][y] == 2){
                visit[nx][ny] = true;
                A_[nx][ny] = 2;
                extend_dfs(nx,ny);
            }
        }
        return false;
    }

    static void count(){

        int cnt = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(A_[i][j] == 0){
                    cnt += 1;
                }
            }
        }

        ans = Math.max(cnt, ans);
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                //visit[i][j]조건을 걸어줘야하는 이유
                // 조건을 걸지 않는다면,
                // 2로 확산된 부분만 돌려놔야하는데, 벽을 세워준곳도 주어진 입력으로 돌아감.
                //따라서 방문했던 곳만 롤백해준다.
                if(visit[i][j]){
                    A_[i][j] = A[i][j];
                }
            }
        }
        visit = new boolean[n+1][m+1];

    }
}
