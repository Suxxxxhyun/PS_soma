package baekjun.src.baekjun.BackTrack;

import java.io.*;
import java.util.*;
//정답의 최대치는 20C10이므로, 2초안에 충분히 풀 수 있음.
//구현 성공!
public class Main14889{

    static int n, ans = Integer.MAX_VALUE;
    static StringTokenizer st;
    static int[][] graph;
    static int[][] selected_start, selected_link;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        selected_start = new int[n/2 + 1][n/2 + 1];
        selected_link = new int[n/2 + 1][n/2 + 1];
        graph = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pro(1);
        System.out.println(ans);
    }

    static void pro(int idx){
        if(idx == n/2 + 1){
            int k = 1;
            for(int i=1,j=1; i<=n; i++){
                if(j <= n/2){
                    if(selected_start[0][j] == i){
                        j++;
                        continue;
                    }
                }
                selected_link[0][k] = i;
                selected_link[k][0] = i;
                k++;
            }
            calculator();
            return;
        }

        int start;
        if(idx == 1){
            start = 1;
        } else {
            start = selected_start[0][idx-1]+1;
        }

        for(int cand=start; cand<=n; cand++){
            selected_start[0][idx] = cand;
            selected_start[idx][0] = cand;
            pro(idx + 1);
        }
    }

    static void calculator(){
        //최대치 : n=10일때, 아래 코드는 10*10 = 100까지의 시간복잡도를 가지게됨.
        int start_grade = 0, link_grade = 0;
        for(int i=1; i<=n/2; i++){
            for(int j=1; j<=n/2; j++){
                if(i == j){
                    continue;
                }
                //selected_start[i][j] = graph[selected_start[i][0]][selected_start[0][j]];
                //selected_link[i][j] = graph[selected_link[i][0]][selected_link[0][j]];
                start_grade += graph[selected_start[i][0]][selected_start[0][j]];
                link_grade += graph[selected_link[i][0]][selected_link[0][j]];
            }
        }
        ans = Math.min(ans, Math.abs(start_grade - link_grade));
    }
}

