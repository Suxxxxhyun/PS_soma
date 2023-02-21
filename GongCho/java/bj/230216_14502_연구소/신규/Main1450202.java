package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;

//ȣ���԰� �ڵ� �ٸ�.
//ȣ�����ڵ忡�� ���� ����� ���� �״�� ��������, ���̷����� Ȯ���Ű�� �κ��� ���� ������ ������ DFS�� ������.
public class Main1450202 {

    static int n,m,B,ans = 0;
    static StringTokenizer st;
    static int[][] A, A_,blank; //blank�迭�� ���� ������ ��ġ�� ��� ���� �迭
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

    //�� ����(0)���ٰ� ���� �� �־��ֱ����� �޼ҵ��, ���� ���� 3�������� ����������, �װ� ������� �ʰ� ����.
    static void pro(){
        //��� ���� ��ġ�� ���� ��Ƴ���. �̶�, B�� ���� ������ �����ֱ� ���� ������.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(A_[i][j] == 0){
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }
        //���� 3�� ����� ��� ����� Ȯ���غ���.
        dfs(1,0);
        System.out.println(ans);
    }

    //idx��° ��ĭ�� ���� ������ ���� �����ؾ��ϰ�, �������� selected_cnt���� ���� ������.
    static void dfs(int idx, int selected_cnt){
        if(selected_cnt == 3){
            // extend_dfs�޼���� ���̷����� Ȯ����Ѻ���.
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

        //���̻� ���� �� �ִ� ���� ���� ����
        if(idx > B){
            return;
        }

        A_[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1); //������ ���� �����ϴ� ���
        A_[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt); //������ ���� �������� �ʴ� ���
    }

    //dfs�޼����� �Ķ����(x,y)�� ������ǥ�� �ǹ���.
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
                //visit[i][j]������ �ɾ�����ϴ� ����
                // ������ ���� �ʴ´ٸ�,
                // 2�� Ȯ��� �κи� ���������ϴµ�, ���� �����ذ��� �־��� �Է����� ���ư�.
                //���� �湮�ߴ� ���� �ѹ����ش�.
                if(visit[i][j]){
                    A_[i][j] = A[i][j];
                }
            }
        }
        visit = new boolean[n+1][m+1];

    }
}
