package baekjun.src.baekjun.greedy;

import java.io.*;
import java.util.*;
//https://hidelookit.tistory.com/158��α� ����
public class Main1715 {

    static int n;
    static PriorityQueue<Long> pq = new PriorityQueue<Long>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            pq.offer(Long.parseLong(br.readLine()));
        }
        pro();
    }

    static void pro(){
        //longŸ������ ������ ���� : 1~�ʸ��� �� ���ϸ� 50��, int���� �ʰ�
        long num = 0;
        //�켱���� ť�� 2�� �̻� ���־�� �񱳰� �����ϴ�.
        while(pq.size() > 1){
            long temp1 = pq.poll();
            long temp2 = pq.poll();

            num += temp1 + temp2;
            pq.add(temp1 + temp2); //���� ���� �ٽ� �ֱ�
        }
        System.out.println(num);
    }
}
