package baekjun.src.baekjun.Tree;

import java.io.*;
import java.util.*;

//원하는 땅에서 1까지 거슬러 올라가면서 소유자가 있는지 없는지 체크하자.
//https://jgeun97.tistory.com/71블로그 참조
public class Main20364 {

    static int n, q;
    static StringTokenizer st;
    static boolean[] visited;
    static int[] duck;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        duck = new int[q];
        for(int i=0; i<q; i++){
            duck[i] = Integer.parseInt(br.readLine());
        }

        pro();
    }

    static void pro(){
        for(int i=0; i<q; i++){
            findRoute(duck[i]);
        }
        System.out.print(sb);
    }

     static void findRoute(int num) {
        int idx = num;
        int ans = 0;
        while(idx != 0){
            if(visited[idx]){
                ans = idx;
            }
            idx /=2;
        }
        sb.append(ans).append('\n');
        if(ans == 0) {
            visited[num] = true;
        }
    }


}
