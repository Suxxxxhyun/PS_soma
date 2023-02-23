package Level3;

class Solution4316302 {

    int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {

        boolean possible = false;
        visited = new boolean[words.length];

        for(int i=0; i<words.length; i++){
            if(target.equals(words[i])){
                possible = true;
                pro(begin, target, words,0,0);
            }
        }

        if(!possible){
            answer = 0;
        }
        return answer;
    }

    public void pro(String begin, String target, String[] words, int cnt, int idx){
        if(begin.equals(target)){
            answer = Math.min(cnt, answer);
            return;
        }

        if(idx == words.length){
            return;
        }

        int same = begin.length() - 1;

        for(int cand = 0; cand < words.length; cand++){
            if(!visited[cand]){
                int same_len = 0;
                for(int i=0; i<begin.length(); i++){
                    if(begin.charAt(i) == words[cand].charAt(i)){
                        same_len++;
                    }
                }

                if(same == same_len){
                    visited[cand] = true;
                    pro(words[cand], target, words, cnt + 1, idx + 1);
                    visited[cand] = false;
                }
            }
        }
    }
}
