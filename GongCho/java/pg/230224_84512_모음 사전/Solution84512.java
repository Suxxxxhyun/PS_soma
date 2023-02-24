package Programmers;

public class Solution84512 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("AAAAE"));
	}
}

class Solution {
    
    int answer = 0;
    String str = "";
    static int cnt = 0;
    
    public int solution(String word) {
        
        pro(str,word,0);
        return answer;
    }
    
    //몇번째(cnt)에 있는 단어인가?
    public boolean pro(String str, String word, int idx){
        if(str.equals(word)){
            answer = cnt;
            return true;
        }
        
        if(idx == 5){
            return true;
        }
        
        cnt++;
        if(pro(str + "A", word, idx+1)) {
        	return true;
        };
        cnt++;
        if(pro(str + "E", word, idx+1)) {
        	return true;
        };
        cnt++;
        if(pro(str + "I", word, idx+1)) {
        	return true;
        };
        cnt++;
        if(pro(str + "O", word, idx+1)) {
        	return true;
        };
        cnt++;
        if(pro(str + "U", word, idx+1)) {
        	return true;
        };
        
        return false;
    }
}
