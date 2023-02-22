package baekjun.src.baekjun.greedy;

import java.io.*;
import java.util.*;
//https://hidelookit.tistory.com/158블로그 참조
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
        //long타입으로 선언한 이유 : 1~십만을 다 더하면 50억, int범위 초과
        long num = 0;
        //우선순위 큐에 2개 이상 들어가있어야 비교가 가능하다.
        while(pq.size() > 1){
            long temp1 = pq.poll();
            long temp2 = pq.poll();

            num += temp1 + temp2;
            pq.add(temp1 + temp2); //합한 묶음 다시 넣기
        }
        System.out.println(num);
    }
}
