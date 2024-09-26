package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 프린터 큐
 * 실버 3
 * 같은 중요도를 가진 문서가 있을 경우를 주의 해야 한다.
 * queue에 넣을 때 찾을 문서를 표시 해준다.
 * 중요도를 배열에 담아준다.
 * 중요도의 max값을 담아준다.
 * que에서 뽑았을 때 max값과 같지 않다면 다시 que에 넣어준다.
 * 같을 경우 개수를 늘려주고 표시한 값이라면 출력해주고 끝내면 된다.
 */
public class No1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            Deque<int[]> que = new ArrayDeque<>();

            String[] notice = br.readLine().split(" ");
            //개수
            int ea = Integer.parseInt(notice[0]);
            //찾을 문서의 번호
            int find = Integer.parseInt(notice[1]);
            //중요도를 담을 배열
            int[] important = new int[10];
            //최대 값을 담아 둘 변수
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<ea;j++){
                int val = Integer.parseInt(st.nextToken());
                if(j == find){
                    que.offer(new int[]{val, 1});
                }else{
                    que.offer(new int[]{val, 0});
                }
                max = Math.max(max, val);
                important[val]++;
            }

            int cnt = 0;
            while(!que.isEmpty()){
                int[] val = que.poll();
                if(val[0] != max){
                    que.offer(val);
                }else{
                    cnt++;
                    if(val[1] == 1){
                        System.out.println(cnt);
                        break;
                    }
                    if(--important[val[0]] == 0){
                        for(int j=val[0]-1;j>=1;j--){
                            if(important[j] > 0){
                                max = j;
                                break;
                            }
                        }
                    }
                }
            }

        }
    }
}
