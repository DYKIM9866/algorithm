package online.judge.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 수 찾기
 * 미완
 */
public class No1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] line = reader.readLine().split(" ");
        reader.readLine();
        StringTokenizer st = new StringTokenizer(reader.readLine());

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        while(st.hasMoreTokens()){
            for(String str : line){
                System.out.println(str);
                if(str.equals(st.nextToken())){
                    writer.write("1\n");
                }else{
                    writer.write("0\n");
                }
            }
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}
