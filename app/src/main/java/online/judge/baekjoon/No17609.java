package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 회문
 * 골드
 */
public class No17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(t-->0){
            String str = br.readLine();
            answer.append(isPalindrome(str)).append("\n");
        }
        System.out.println(answer);
    }

    private static int isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);

        int lt = 0;
        int rt = str.length()-1;
        while(lt < rt){
            if(sb.charAt(lt) == sb.charAt(rt)){
                rt--;
                lt++;
            }else{
                StringBuilder delLeft = new StringBuilder(sb).deleteCharAt(lt);
                StringBuilder delRight = new StringBuilder(sb).deleteCharAt(rt);
                if(delLeft.toString().contentEquals(delLeft.reverse())
                    || delRight.toString().contentEquals(delRight.reverse())){
                    return 1;
                }
                return 2;
            }
        }

        return 0;
    }
}
