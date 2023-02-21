package baekjun.src.baekjun.greedy;

import java.io.*;
import java.util.*;

//https://st-lab.tistory.com/145��α� ����
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
            //����ð��� ���ٸ�, ���۽ð��� �������� �ٽ� ����.
            //�� ������ �Է���
            //8 8
            //4 8
            //1 3�̶�� ������, ����ð��� ���ٸ�, ���۽ð��� �������� �ٽ� ������ ������ �ʴ´ٸ�,
            //>> 1 3 / 8 8 / 4 8�� ������ ���ٵ�, �Ʒ� �ڵ带 �����ϸ�, 1 3 / 8 8�� cnt�� 2�� ��.
            //�׷��� ����� 1 3 / 4 8 / 8 8��� ���� �����ϹǷ�, cnt�� 3�� �Ǿ����.
            //����, ����ð��� ���ٸ�, ���۽ð��� �������� �ٽ� �������ش�.
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
