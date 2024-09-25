package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 골드 4
 * 괄호 제거
 * dfs를 사용해서 풀이
 * 완료
 */
public class No2800 {
    //중복을 방지하기 위해 Set 자료구조 사용
    private static final Set<String> strSet = new HashSet<>();
    private static String str;
    private static List<int[]> parentheses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        Deque<Integer> stack = new ArrayDeque<>();
        parentheses = new ArrayList<>();
        //stack을 사용해서 괄호쌍을 찾아 인덱스 저장
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(') stack.push(i);
            else if(str.charAt(i) == ')'){
                parentheses.add(new int[]{stack.pop(), i});
            }
        }
        //괄호 쌍 인덱스 저장 수 만큼 체크 배열 선언
        boolean[] check = new boolean[parentheses.size()];
        dfs(0,check);

        List<String> list = new ArrayList<>(strSet);
        list.sort(String::compareTo);

        for(String s : list){
            System.out.println(s);
        }
    }

    private static void dfs(int depth, boolean[] check) {
        if(depth == check.length){
            int deleteCnt = 0;
            List<Integer> deleteArr = new ArrayList<>();
            StringBuilder sb = new StringBuilder(str);

            //제거해야 할 괄호 넣어주기
            for(int i=0;i<check.length;i++){
                if(!check[i]){
                    int[] tmp = parentheses.get(i);
                    deleteArr.add(tmp[0]);
                    deleteArr.add(tmp[1]);
                }
            }
            //제거 해야 할 것이 없으면 입력받은 값과 같으므로 return
            if(deleteArr.isEmpty()) return;
            //제거해야 할 괄호 인덱스 오름차순 정렬
            deleteArr.sort(Integer::compareTo);
            //빼 줄 때마다 전체 인덱스 줄어드는 것을 생각하여 빼줌
            for(int x : deleteArr){
                sb.deleteCharAt(x-deleteCnt++);
            }
            strSet.add(sb.toString());
            return;
        }

        check[depth] = true;
        dfs(depth+1 , check);

        check[depth] = false;
        dfs(depth+1 , check);

    }
}
