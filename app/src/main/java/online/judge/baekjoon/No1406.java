package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 에디터
 * 실버2
 * 커맨드 마다 명령어 처리를 해주면 되는데
 * 커서 위치를 잘 생각해야 한다.
 * 커서를 인덱스를 기준으로 하고 인덱스의 항상 오른쪽에 있다고 생각한다.
 * -1~sb.length-1 까지 가능해 지는 것
 * 커서를 이동시킬 때는 각 끝 값에 있지 않을 경우에만 이동시켜주고
 * 제거 할 때는 인덱스 감소시키면서 제거
 * 추가 할 때는 인덱스를 먼저 올려주면서 추가해야 한다.
 */
public class No1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringBuilder sb = new StringBuilder(br.readLine());
        int idx = sb.length()-1;
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++){
            String[] command = br.readLine().split(" ");
            switch (command[0]){
                case "L":
                    if(idx != -1){
                        idx--;
                    }
                    break;
                case "D":
                    if(idx != sb.length()-1){
                        idx++;
                    }
                    break;
                case "B":
                    if(idx != -1){
                        sb.deleteCharAt(idx--);
                    }
                    break;
                case "P":
                    sb.insert(++idx,command[1]);
                    break;
            }
        }


        System.out.println(sb);
    }
}
