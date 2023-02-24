package Programmers;

class Solution87946 {
    
    int answer = -1;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        pro(k, dungeons, 0, 0);
        return answer;
    }
    
    public void pro(int k, int[][] dungeons, int depth, int selected_cnt){
        if(depth == dungeons.length){
            answer = Math.max(selected_cnt, answer);
            return;
        }
        
        
        for(int cand = 0; cand < dungeons.length; cand++){
            if(!visited[cand]){                                                     
                if(dungeons[cand][0] <= k){
                    visited[cand] = true;
                    pro(k - dungeons[cand][1], dungeons, depth + 1, selected_cnt + 1);
                    visited[cand] = false;
                } else {
                    pro(k, dungeons, depth + 1, selected_cnt);   
                }
            } 
        }
    }
}
