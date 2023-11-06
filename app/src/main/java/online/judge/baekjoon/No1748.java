package online.judge.baekjoon;

import java.io.*;

/**
 * 수 이어 쓰기1 실버4
 * 완료 231103
 * 풀긴풀었는데 억지로 풀었음 구현해서.. 이렇게 해도될란지..
 */
public class No1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();
        int count = 0;
        int size = n.length();

        for(int i=1;i<=size-1;i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i*9);
            for(int j=1;j<i;j++){
                sb.append(0);
            }
            count += Integer.parseInt(sb.toString());
        }
        if(size != 1){
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            for(int i=0;i<size-1;i++){
                sb.append(0);
            }
            count += (Integer.parseInt(n)-Integer.parseInt(sb.toString())+1) * size;
        }else {
            count += Integer.parseInt(n);
        }

        System.out.println(count);
        reader.close();
    }

}
