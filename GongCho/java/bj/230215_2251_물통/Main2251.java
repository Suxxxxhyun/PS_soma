package baekjun.src.baekjun.BFSDFS;

import java.io.*;
import java.util.*;

//구현 실패(호석님코드)
public class Main2251 {

    static int[] Limit = new int[3];

    //possible : 정답에 가능한 값들을 출력하기 위한 배열
    static boolean[]  possible = new boolean[205];
    static boolean[][][] visit = new boolean[205][205][205];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 물통의 현재 상태와 물을 붓는 행위를 관리하는 구조체
    static class State{
        int[] X;
        State(int[] _X){
            X = new int[3];
            for (int i=0;i<3;i++) {
                X[i] = _X[i];
            }
        }

        State move(int from,int to,int[] Limit){
            // from 물통에서 to 물통으로 물을 옮긴다. -> from -> to로 붓다가, from이 먼저 비는 경우와 to가 먼저 차는 경우로 나뉨.
            int[] nX = new int[]{X[0], X[1], X[2]};
            if (X[from] + X[to] <= Limit[to]){  // 만약 from 을 전부 부을 수 있다면 (from이 먼저 비는 경우)
                nX[to] = nX[from] + nX[to];
                nX[from] = 0;
            }else{  // from 의 일부만 옮길 수 있는 경우 (to가 먼저 차는 경우)
                nX[from] -= Limit[to] - nX[to];
                nX[to] = Limit[to];
            }
            return new State(nX);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<3; i++){
            Limit[i] = Integer.parseInt(st.nextToken());
        }

        pro();
    }

    static void pro(){
        bfs(0,0,Limit[2]);
        for(int i=0; i<=200; i++){
            if(possible[i]){
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    // 물통 탐색 시작~
    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true; //
        Q.add(new State(new int[]{x1, x2, x3}));

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            State st = Q.poll();
            if (st.X[0] == 0) { //A번 물통이 비어있다면, 이것이 곧 정답.
                possible[st.X[2]] = true;
            }
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) {
                        continue; //같은 물통끼리는 물을 부을 필요가 없음.
                    }
                    // i 번 물통에서 j 번 물통으로 물을 옮긴다.
                    State nxt = st.move(from, to, Limit);

                    // 만약 바뀐 상태를 탐색한 적이 없다면
                    if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
    }


}
