package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 골드 5
 * 0 만들기
 * 완료
 */
public class No7490 {
    //출력 할 식을 저장
    private static List<String> sik;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            //매 다른 케이스를 위해서 반복해서 초기화
            sik = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            //1은 고정으로 +로 입력 되므로 1추가
            sb.append(1);
            makeZero(2,n,sb);
            //정렬
            sik.sort(String::compareTo);
            for(String str : sik){
                System.out.println(str);
            }
            System.out.println();
        }
    }

    private static void makeZero(int current, int n, StringBuilder sb) {

        if(current > n){
            String str = sb.toString().replaceAll(" ","");
            int sum = 0;
            for(int i=0;i<str.length();i++){
                //숫자를 만나면 +,-나올때까지 가다가 나오면 멈춰주고 값을 더해줌
                if(str.charAt(i) >= '0' && str.charAt(i) <='9'){
                    StringBuilder val = new StringBuilder();
                    for(int j=i;j<str.length();j++){
                        if(str.charAt(j) == '+' || str.charAt(j) == '-')break;
                        val.append(str.charAt(j));
                    }
                    int merge = Integer.parseInt(val.toString());
                    int mul = 1;
                    if(i != 0) {
                        if(str.charAt(i-1) == '-') mul *= -1;
                    }
                    sum += merge * mul;
                    i += val.length();
                }
            }
            if(sum != 0) return;
            sik.add(sb.toString());
            return;
        }

        //세가지 경우에 대해 sb를 변경 후 넣어줌
        //더하기
        sb.append("+").append(current);
        makeZero(current+1, n, sb);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        //빼기
        sb.append("-").append(current);
        makeZero(current+1, n, sb);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        //이어붙히기
        sb.append(" ").append(current);
        makeZero(current+1, n, sb);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);

    }

//    private static List<String> sik;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int t = Integer.parseInt(br.readLine());
//        for (int i = 0; i < t; i++) {
//            int n = Integer.parseInt(br.readLine());
//            sik = new ArrayList<>();
//            StringBuilder sb = new StringBuilder();
//            sb.append(1);
//            makeZero(2, n, 1, sb);
//
//            sik.sort(String::compareTo);
//            for(String str : sik){
//                System.out.println(str);
//            }
//        }
//    }
//
//    private static void makeZero(int current, int n, int val, StringBuilder sb) {
//        if(current > n){
//            if(val != 0) return;
//            sik.add(sb.toString());
//            return;
//        }
//        //더하기
//        sb.append("+").append(current);
//        makeZero(current+1,n,val+current,sb);
//
//        sb.deleteCharAt(sb.length()-1);
//        sb.deleteCharAt(sb.length()-1);
//
//        //빼기
//        sb.append("-").append(current);
//        makeZero(current+1,n,val-current,sb);
//
//        sb.deleteCharAt(sb.length()-1);
//        sb.deleteCharAt(sb.length()-1);
//
////        //이어 붙이기
////        sb.append(" ").append(current);
////        int merge = Integer.parseInt(String.format("%d%d",current-1,current));
////        makeZero(current+1,n,val + merge,sb);
////        if(current != 2){
////            makeZero(current+1,n,val - merge,sb);
////        }
////
////        sb.deleteCharAt(sb.length()-1);
////        sb.deleteCharAt(sb.length()-1);
//    }
}
