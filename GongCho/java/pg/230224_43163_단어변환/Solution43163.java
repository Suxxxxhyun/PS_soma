package Level3;

class Solution43163 {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        boolean possible = false;

        for(int i=0; i<words.length; i++){
            int cnt = 0;
            for(int j=0; j<target.length(); j++){
                if(target.charAt(j) == words[i].charAt(j)){
                    cnt += 1;
                }
            }

            if(cnt == target.length()){
                possible = true;
                dfs(begin, target, words, 0);
            }
        }

        if(!possible){
            answer = 0;
        }
        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = Math.min(answer,cnt);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int k = 0;    // 같은 스펠링 몇개인지 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }
            }

            if (k == begin.length() - 1) {  // 한글자 빼고 모두 같은 경우
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
