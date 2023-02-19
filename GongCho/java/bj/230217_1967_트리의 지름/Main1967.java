package baekjun.src.baekjun.Tree;

import java.io.*;
import java.util.*;

//https://code-lab1.tistory.com/111블로그 참조
//전위순회(preorder) : 루트 - 왼쪽 - 오른쪽
//중위순회(inorder) : 왼쪽 - 루트 - 오른쪽
//후위순회(postorder) : 왼쪽 - 오른쪽 - 루트
//https://www.youtube.com/watch?v=1VNWJTbE2pM 유튜브 참조

//주어진 트리의 지름을 구하기 위해서는 꼭 root를 거칠 필요는 없음.
//트리의 최대 지름을 구하기 위해서는 리프노드에 도달해야됨.(리프가 아닌곳에서 시작한다면, 이는 최대 지름이 아님!)
//즉, 리프노드와 리프노드간의 거리임.
//따라서, 모든 리프노드에서 dfs탐색을 하여 다른 리프노드까지의 거리를 구하고, 최대 거리를 갱신하면 됨.

//리프노드를 구별하는 방법은, 루트노드가 아니면서 연결노드가 1개뿐인 노드를 구하면 됨.
//리프노드를 구별하여 따로 저장해놓고, 모든 리프노드에서 dfs탐색을 진행하면 된다.
public class Main1967{

    static int N, ans;
    static ArrayList<Pair> tree[];
    static boolean visited[];

    static class Pair{
        int link;
        int w;
        Pair(int a, int b){
            this.link = a;
            this.w = b;
        }
    }
    static ArrayList<Integer> leaf = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new Pair(b,c));
            tree[b].add(new Pair(a,c));
        }

        /* 리프노드 구하기 */
        for(int i=2; i<=N; i++) {
            if(tree[i].size() <2) {
                leaf.add(i);
                //System.out.println(i);
            }
        }

        /* 모든 리프노드에서 DFS 탐색 */
        for(int i=0; i<leaf.size(); i++) {
            visited = new boolean[N+1];
            visited[leaf.get(i)] = true;
            dfs(leaf.get(i), 0, leaf.get(i));
        }

        System.out.println(ans);

    }
    private static void dfs(int idx, int sum, int start) {
        if(tree[idx].size() == 1 && idx != start) {    // 리프노드라면
            ans = Math.max(ans,sum);
            return;
        }

        for(int i=0; i<tree[idx].size(); i++) {
            int next = tree[idx].get(i).link;
            if(!visited[next]) {
                visited[next] = true;
                dfs(next, sum+tree[idx].get(i).w, start);
            }
        }
    }
}