package online.judge.baekjoon;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

/**
 * 영수증
 * 완료 230926
 */
public class No25304 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        CharBuffer charBuffer = CharBuffer.allocate(1_000_000);
        reader.read(charBuffer);
        charBuffer.flip();

        String[] strArr = charBuffer.toString().split("\n");
        int total = Integer.parseInt(strArr[0]);
        int sum = 0;
        for(int i=2;i<Integer.parseInt(strArr[1]) + 2;i++){
            String[] priceCount = strArr[i].split(" ");
            int price = Integer.parseInt(priceCount[0]);
            int count = Integer.parseInt(priceCount[1]);
            sum += price*count;
        }
        if(total == sum){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }


    }
}
