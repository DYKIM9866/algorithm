package online.judge.baekjoon;

import java.io.*;
import java.math.BigInteger;

/**
 * 팩토리얼 3 브론즈5
 * 미완
 */
public class No27434 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger big = new BigInteger(reader.readLine());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(facto(big).toString());
        writer.close();
        reader.close();
    }

    private static BigInteger facto(BigInteger big) {
        BigInteger ill = new BigInteger("1");
        if(big.toString().equals("0")){
            return ill;
        }
        if (big.toString().equals("1")) {
            return ill;
        }
        return big.multiply(facto(big.subtract(ill)));
    }
}
