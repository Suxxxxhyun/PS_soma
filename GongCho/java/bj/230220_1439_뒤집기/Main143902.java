package baekjun.src.baekjun.greedy;

import java.io.*;

//구현 성공
public class Main143902 {

    static int zero_cnt, one_cnt;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String make_str = "";
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                continue;
            } else {
                make_str += str.charAt(i);
            }
        }
        make_str += str.charAt(str.length()-1);

        for(int i=0; i<make_str.length(); i++) {
            if(make_str.charAt(i) - '0' == 0) {
                zero_cnt += 1;
            } else {
                one_cnt += 1;
            }
        }

        if(zero_cnt >= one_cnt) {
            System.out.println(one_cnt);
        } else {
            System.out.println(zero_cnt);
        }

    }

}

