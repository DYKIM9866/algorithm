package online.judge.baekjoon;

import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * 세로읽기
 * 완료 230927
 */
public class No10798 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] chrArr = new char[5][15];
        CharBuffer charBuffer = CharBuffer.allocate(76);

        for(int i=0;i<5;i++){
            chrArr[i] = scan.nextLine().toCharArray();
        }
        for(int i=0;i<15;i++){
            for(int j=0;j<5;j++){
                if(chrArr[j].length-1 >= i){
                    charBuffer.append(chrArr[j][i]);
                }
            }
        }
        charBuffer.flip();
        System.out.println(charBuffer);
    }
}
