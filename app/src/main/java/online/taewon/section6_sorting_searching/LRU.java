package online.taewon.section6_sorting_searching;

import java.util.Scanner;

public class LRU {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        int n = scan.nextInt();
        int[] action = new int[n];
        for (int i = 0; i < n; i++) {
            action[i] = scan.nextInt();
        }

        System.out.println(mySol(s,n,action));
    }

    private static String mySol(int s, int n, int[] action) {
        String result = "";
        int[] cache = new int[s];

        for(int x : action){
            int i = -1;
            for(int j=0;j<s;j++){
                if(x == cache[j]){
                    i = j;
                    break;
                }
            }
            if(i != -1){
                for(int k=i-1;k>=0;k--){
                    cache[k+1] = cache[k];
                }
            }else{
                for(int k=s-1;k>0;k--){
                    cache[k] = cache[k-1];
                }
            }
            cache[0] = x;
        }

        for(int x : cache){
            result += x + " ";
        }

        return result;
    }
}
