package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.StringTokenizer;

/**
 * 진법 변환2
 * 완료 230927
 */
public class No11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long n = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        CharBuffer charBuffer = CharBuffer.allocate(1_000_000);


        while(n != 0){
            long y = n%b;
            n /= b;
            charBuffer.append(getChar(y));
        }
        charBuffer.flip();
        for(int i=charBuffer.length()-1;i>=0;i--){
            System.out.print(charBuffer.charAt(i));
        }
    }

    private static char getChar(long y) {
        if(y > 9){
            return (char)(y + 55);
        }else{
            return  (char)(y + 48);
        }
    }
}
