package online.twoweeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Intro {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        System.out.println("헬로우 자바!");
    }
}
