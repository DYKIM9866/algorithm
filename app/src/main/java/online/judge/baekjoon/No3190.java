package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 뱀
 * 골드 4
 */
public class No3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n만큼의 map을 생성
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        //사과 위치를 1로 표시
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            String[] apple = br.readLine().split(" ");
            map[Integer.parseInt(apple[0])-1][Integer.parseInt(apple[1])-1]
                    = 1;
        }

        //방향전환의 초를 배열의 값의 양,음으로 조절
        int l = Integer.parseInt(br.readLine());
        int[] events = new int[l];
        for (int i = 0; i < l; i++) {
            String[] command = br.readLine().split(" ");
            if(command[1].equals("L")){
                events[i] = -1 * Integer.parseInt(command[0]);
            }else{
                events[i] = Integer.parseInt(command[0]);
            }
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        //방향
        int direct = 0;
        //초
        int second = 0;
        //방향전환 인덱스
        int eventIdx = 0;
        //뱀의 크기와 위치
        Deque<int[]> snake = new ArrayDeque<>();
        //뱀의 초기값 설정
        snake.offer(new int[]{0,0});
        map[0][0] = 2;
        while(true){
            second++;
            //머리부분의 좌표값
            int[] head = snake.peekLast();
            int nx = head[0] + dx[direct];
            int ny = head[1] + dy[direct];
            if(nx < 0 || nx == n
               || ny < 0 || ny == n
               || map[nx][ny] == 2){
                break;
            }
            //사과가 아닐경우 꼬리를 내보내고 map 고쳐줌
            if(map[nx][ny] != 1){
                int[] tail = snake.pollFirst();
                map[tail[0]][tail[1]] = 0;
            }
            snake.offer(new int[]{nx, ny});
            map[nx][ny] = 2;

            //사건 발생 하는지 확인
            if(eventIdx < l && second == Math.abs(events[eventIdx])){
                if(events[eventIdx] > 0){
                    direct++;
                }else{
                    direct--;
                }

                if(direct == -1){
                    direct = 3;
                }
                if(direct == 4){
                    direct = 0;
                }
                eventIdx++;
            }
        }

        System.out.println(second);
    }
}
