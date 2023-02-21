package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;

//ȣ�����ڵ�
public class Main1450203 {
    static int n,m,B,ans = 0;
    static StringTokenizer st;
    static int[][] A,blank; //blank�迭�� ���� ������ ��ġ�� ��� ���� �迭
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

    //�� ����(0)���ٰ� ���� �� �־��ֱ����� �޼ҵ��, ���� ���� 3�������� ����������, �װ� ������� �ʰ� ����.
    static void pro(){
        //��� ���� ��ġ�� ���� ��Ƴ���. �̶�, B�� ���� ������ �����ֱ� ���� ������.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(A[i][j] == 0){
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
            bfs();
            return;
        }

        //���̻� ���� �� �ִ� ���� ���� ����
        if(idx > B){
            return;
        }

        A[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1); //������ ���� �����ϴ� ���
        A[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt); //������ ���� �������� �ʴ� ���
    }

    // ���̷��� �۶߸���!!
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        // ��� ���̷����� ���������� �����ϴϱ�, ���� ť�� �־��ش�.
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

        // BFS ����
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

        // Ž���� ����� �����̴�, ���� ������ ���̸� ����ϰ�, ������ �����Ѵ�.
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
                //!visit[i][j]�� ���� ���� + 0�� �����̹Ƿ�,
                //A[i][j] == 0�� �ͱ��� ������ �ɾ
                //���������� ������ �����ش�.
                if (A[i][j] == 0 && !visit[i][j]) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }
}
