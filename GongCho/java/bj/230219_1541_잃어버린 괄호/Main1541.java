package baekjun.src.baekjun.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://st-lab.tistory.com/148 참조
//최솟값이 되려면, 가장 큰수를 빼주어야하는데,
//그러기 위해서,
//뺄셈(-)을 기준으로 분리해준뒤,
//분리된 문자열들을 각각 더해준다.
//각각 더해진 값을 뺄셈해준다.
public class Main1541 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = Integer.MAX_VALUE;
        String[] substraction = br.readLine().split("-");

        for(int i=0; i<substraction.length; i++){
            int temp = 0;

            //뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
            String[] addition = substraction[i].split("\\+");

            //덧셈으로 나뉜 토큰들을 모두 더한다.
            for(int j=0; j<addition.length; j++){
                temp += Integer.parseInt(addition[j]);
            }

            //첫번째 토큰인 경우, temp값이 첫번째 수가 됨.
            if(sum == Integer.MAX_VALUE){
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);

    }

}
