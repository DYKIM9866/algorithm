package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 숫자판 점프
 * 실버 2
 * 문제 해석
 * 1. 5x5 숫자판에 1~9까지의 숫자가 들어있다.
 * 2. 위, 아래, 오른쪽, 밑 까지 해서 돌아다니며 숫자 6개를 만든다.
 * 3. 그렇게 해서 만들 수 있는 숫자가 몇개냐
 * 4. 갔던 곳도 돌아갈 수 있다.
 *
 * 풀이
 * 1. 전역변수로 숫자판, 만든 숫자를 중복 없이 담아줄 Set, (위,오,아,왼)을 배열을 선언
 * 2. 각 숫자판에서 시작하여 length가 6이 될 때가지 값을 추가해 주다가 넣어준다.
 * 3. 전부다 돌고나면 개수를 뽑아준다.
 */
public class No2210 {
    static char[][] map;
    static Set<String> set;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        set = new HashSet<>();
        //지도 채우기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                StringBuilder sb = new StringBuilder();
                //현재 위치 값 넣어주기
                sb.append(map[i][j]);
                //매개변수로 좌표와, SB전달
                findCase(i,j,sb);
            }
        }
        System.out.println(set.size());
    }

    private static void findCase(int i, int j, StringBuilder sb) {
        //길이가 6이 되면 추가
        if(sb.length() == 6){
            set.add(sb.toString());
            return;
        }

        for (int z = 0; z < 4; z++) {
            int nx = i + dx[z];
            int ny = j + dy[z];
            if(nx < 0 || ny < 0 || nx >=5 || ny >= 5) continue;
            sb.append(map[nx][ny]);
            findCase(nx, ny, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
