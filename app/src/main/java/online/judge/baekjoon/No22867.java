package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 종점
 * 버스가 차고지에 머무를 때 겹치는 것을 세야 한다.
 * 들어오는 시간과 나가는 시간을 구분하기 위해 뒤에 0과 1을 넣어주고 받는데
 * 같은 시간에 들어오는 경우 나가고 들어오기때문에 들어올 때 1을 해서 정렬 시에 뒤로 갈 수 있도록 한다.
 * 시간이 지날 때마다 개수를 세면 끝
 * 완료
 */
public class No22867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int garage = 0;
        List<String> times = new ArrayList<>();
//        String[] times = new String[n*2];
        for (int i = 0; i < n*2; i+=2) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times.add(st.nextToken() + "1");//들어오는거
            times.add(st.nextToken() + "0");//나가는거
//            times[i] = st.nextToken() + "1";//들어오는거
//            times[i+1] = st.nextToken() + "0";//나가는거
        }

//        Arrays.sort(times);
        times.sort(String::compareTo);

        for(String str : times){
            if(str.charAt(str.length()-1) == '1'){
                garage++;
                answer = Integer.max(answer, garage);
            }else{
                garage--;
            }
        }
        System.out.println(answer);
    }
}
