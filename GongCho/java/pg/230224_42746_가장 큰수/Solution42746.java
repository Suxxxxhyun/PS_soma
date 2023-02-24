package Level2;

//https://middleearth.tistory.com/100블로그 참조
import java.util.*;
public class Solution42746 {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        /*
        두개의 문자를 조합했을때, 큰 수가 되는 것을 선택한다.(버블정렬과정을 거쳐서 가장 큰수가 되게 하자.)
        {3, 30, 34, 5, 9}이라고 하였을때,
        1. 원사이클
            -1. (330, 303) -> (515148, 514851 => 비교가 될때는 아스키코드의 값들의 모임으로 비교됨.)
                330이 더 크므로, 3 30은 순서가 바뀌지 않는다. (compareTo메서드는 왼쪽의 파라미터값이 작으면, 오름차순정렬임)
            -2. (3034, 3430) -> 3430이 더 크므로, 30과 34의 순서가 바뀐다. => {3, 34, 30, 5, 9}
            -3. (345, 534) -> 534이 더 크므로, 5와 34의 순서가 바뀐다. => {3, 34, 5, 30, 9}
            -4. (30, 9) -> 9가 더 크므로, 30과 9의 순서가 바뀐다. => {3, 34, 5, 9, 30}

            => 결과적으로 oneStep에서는 {3, 34, 5, 9, 30} 반환

        이 과정을 다 거치면 {9 5 34 3 30}이 된다.
         */
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        /*for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }*/

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }


        return answer.toString();
    }
}
