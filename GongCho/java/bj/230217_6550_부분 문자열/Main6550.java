package baekjun.src.baekjun.String;

import java.io.*;
import java.util.*;
public class Main6550 {

    static String s,t;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str == null){
                break;
            }
            st = new StringTokenizer(str, " ");
            s = st.nextToken();
            t = st.nextToken();
            pro();
        }
    }

    static void pro(){
        int L = 0;
        for(int R=0; R<t.length(); R++){
            if(s.charAt(L) == t.charAt(R)){
                L++;
            }

            //예제3처럼 s의 길이가 더 짧으며, 부분문자열이 가능한경우, L은 이미 5가 됨.
            //이미 L이 5가 된상황에서, 23번줄처럼 비교를 하려고 하면 오류가 날테니,
            //그냥 빠져나가자.
            if(L == s.length()){
                System.out.println("Yes");
                return;
            }
        }
        if(L == s.length()){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
