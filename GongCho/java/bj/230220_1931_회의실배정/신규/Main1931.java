package baekjun.src.baekjun.greedy;

import java.io.*;
import java.util.*;

//https://st-lab.tistory.com/145블로그 참조
public class Main1931 {

    static int n;
    static int[][] lecture;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        lecture = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lecture[i][0] = start;
            lecture[i][1] = end;
        }

        Arrays.sort(lecture, (o1, o2) -> {
            //종료시간이 같다면, 시작시간을 기준으로 다시 정렬.
            //그 이유는 입력이
            //8 8
            //4 8
            //1 3이라고 했을때, 종료시간이 같다면, 시작시간을 기준으로 다시 정렬을 해주지 않는다면,
            //>> 1 3 / 8 8 / 4 8로 정렬이 될텐데, 아래 코드를 진행하면, 1 3 / 8 8로 cnt는 2가 됨.
            //그러나 사실은 1 3 / 4 8 / 8 8모두 선택 가능하므로, cnt는 3이 되어야함.
            //따라서, 종료시간이 같다면, 시작시간을 기준으로 다시 정렬해준다.
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int cnt = 0;
        int end = 0;

        for(int i=0; i<n; i++){
            if(end <= lecture[i][0]){
                end = lecture[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
