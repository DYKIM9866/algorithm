package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 완전 이진 트리
 * 실버 1
 * 문제 해석
 * 1. 입력으로 상근이가 방문하는 순서가 주어진다.
 * 2. 순서를 보면 중위순회를 한다.
 *
 * 풀이
 * 1. 중위 순회의 경우 가운데가 부모 값임
 * 2. 배열로 순서를 받음
 * 3. 전체 배열을 기준으로 DFS를 돌림
 * 4. 중앙 값을 부모 값으로 두고 depth를 추가 하면서 양 옆의 배열들을 재귀를 태움
 */
public class No9934 {
    static StringBuilder[] answer;
    static int[] arr;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new int[(int)Math.pow(2,k)-1];
        answer = new StringBuilder[k];

        //answer에 StringBuilder를 초기화 해줌
        for (int i = 0; i < k; i++) {
            answer[i] = new StringBuilder();
        }

        //배열에 순서를 담아줌
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //배열의 인덱스와 ,depth를 매개변수로 전달
        makeTree(0, arr.length - 1, 0);
        for(StringBuilder sb : answer){
            System.out.println(sb);
        }
    }

    private static void makeTree(int start, int end, int depth) {
        //depth가 k와 같으면 return
        if(depth == k) return;
        //중앙 값 구하기
        int idx = (start + end)/2;
        //StringBuilder에 root값 추가
        answer[depth].append(arr[idx]).append(' ');
        //재귀 태우기
        makeTree(start, idx-1, depth + 1);
        makeTree(idx+1, end, depth + 1);
    }
}
