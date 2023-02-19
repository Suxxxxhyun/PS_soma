package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;

//호석님코드
public class Main1450203 {
    static int n,m,B,ans = 0;
    static StringTokenizer st;
    static int[][] A,blank; //blank배열은 벽이 세워진 위치를 담기 위한 배열
    static boolean[][] visit;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n+1][m+1];
        blank = new int[n * m + 1][2];
        visit = new boolean[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=m; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pro();
    }

    //빈 공간(0)에다가 벽을 다 넣어주기위한 메소드로, 원래 벽은 3개까지만 가능하지만, 그걸 고려하지 않고 있음.
    static void pro(){
        //모든 벽의 위치를 먼저 모아놓자. 이때, B는 벽의 개수를 세어주기 위한 변수임.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(A[i][j] == 0){
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
            bfs();
            return;
        }

        //더이상 세울 수 있는 벽이 없는 상태
        if(idx > B){
            return;
        }

        A[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1); //선택한 벽을 포함하는 경우
        A[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt); //선택한 벽을 포함하지 않는 경우
    }

    // 바이러스 퍼뜨리기!!
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        // 모든 바이러스가 시작점으로 가능하니까, 전부 큐에 넣어준다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                visit[i][j] = false;
                if (A[i][j] == 2) {
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                }
            }
        }

        // BFS 과정
        while (!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 1 || ny < 1 || nx > n || ny > m) {
                    continue;
                }
                if (A[nx][ny] != 0) {
                    continue;
                }
                if (visit[nx][ny]) {
                    continue;
                }
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }

        // 탐색이 종료된 시점이니, 안전 영역의 넓이를 계산하고, 정답을 갱신한다.
        int cnt = 0;
        /*for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                System.out.print(visit[i][j] + " ");
            }
            System.out.println();
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }*/
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //!visit[i][j]는 벽의 개수 + 0의 개수이므로,
                //A[i][j] == 0인 것까지 조건을 걸어서
                //안전영역의 개수를 세어준다.
                if (A[i][j] == 0 && !visit[i][j]) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }
}
