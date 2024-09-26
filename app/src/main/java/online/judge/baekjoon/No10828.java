package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10828 {
    public static int[] stack;
    public static int size=-1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        stack = new int[N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine()," ");
            String str = st.nextToken();

            switch(str) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size+1);
                    break;
                case "empty":
                    if(size==-1) {
                        System.out.println(1);
                    }else {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if(size==-1) {
                        System.out.println(size);
                        break;
                    }
                    System.out.println(stack[size]);
            }
        }
    }

    public static void push(int n) {
        stack[++size] = n;
    }
    public static int pop() {
        if(size==-1) {
            return size;
        }
        int x = stack[size];
        stack[size--] = 0;
        return x;
    }
}