package Level2;

public class Solution42842 {
    public int[] solution(int brown, int yellow){
        int[] answer = new int[2];
        int sum = brown + yellow;

        //brown, yellow가 각각 24, 24일때,
        for(int i=3; i<sum; i++){
            int j = sum / i; //16

            if(sum % i == 0 && j >= 3){
                int col = Math.max(i,j);
                int row = Math.min(i,j);

                if(yellow == (col - 2) * (row - 2)){
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }

        return answer;
    }
}
