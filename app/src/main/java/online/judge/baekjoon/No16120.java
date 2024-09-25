package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드 4
 * PPAP
 * 한번의 반복문으로 해결해야 함
 */
public class No16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //P의 개수를 셀 변수
        int p = 0;
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'P') p++;
            else{
                //A를 만났을 때 앞에 P의 개수가 2개 이상이고 뒤의 문자가 P면 PPAP -> P
                if(p >= 2 && i != str.length()-1 && str.charAt(i+1) == 'P'){
                    p -=2;
                }else{
                    //A를 만났을 때 위의 조건을 만족하지 않으면 절대 P가 될 수 없다
                    System.out.println("NP");
                    return;
                }
            }
        }
        if(p == 1){
            System.out.println("PPAP");
        }else{
            System.out.println("NP");
        }
    }
}
