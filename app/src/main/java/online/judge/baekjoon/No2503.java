package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 숫자 야구
 * 인프런 알고
 * 완료 완탐
 */
public class No2503 {
    public static void main(String[] args) throws IOException {

        boolean[] check = new boolean[1000];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<List<String>> hint = new ArrayList<>();

        while(n --> 0){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            hint.add(List.of(st.nextToken(),st.nextToken(),st.nextToken()));
        }

        for(int i=111;i<1000;i++){
            String iStr = String.valueOf(i);
            String[] div = iStr.split("");
            String fir = div[0];
            String sec = div[1];
            String thr = div[2];
            if(iStr.contains("0")){
                continue;
            }
            if(fir.equals(sec) || sec.equals(thr) || thr.equals(fir)){
                continue;
            }

            for(List<String> list : hint){
                String[] testNumArr = list.get(0).split("");
                String strFir = testNumArr[0];
                String strSec = testNumArr[1];
                String strThr = testNumArr[2];
                int strike = Integer.parseInt(list.get(1));
                int ball = Integer.parseInt(list.get(2));
                int strikeCount = 0;
                int ballCount = 0;

                if(iStr.contains(strFir)){
                    if(fir.equals(strFir)){
                        strikeCount++;
                    }else{
                        ballCount++;
                    }
                }
                if(iStr.contains(strSec)){
                    if(sec.equals(strSec)){
                        strikeCount++;
                    }else{
                        ballCount++;
                    }
                }
                if(iStr.contains(strThr)){
                    if(thr.equals(strThr)){
                        strikeCount++;
                    }else{
                        ballCount++;
                    }
                }
                if(strikeCount == strike && ballCount == ball){
                    check[i] = true;
                }else{
                    check[i] = false;
                    break;
                }
            }
        }
        int result = 0;
        for(boolean bool : check){
            if(bool){
                result++;
            }
        }
        System.out.println(result);

    }
}
