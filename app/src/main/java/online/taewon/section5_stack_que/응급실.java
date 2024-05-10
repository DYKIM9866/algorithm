package online.taewon.section5_stack_que;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Patient{
    int id;
    int score;
    public Patient(int id, int score) {
        this.id = id;
        this.score = score;
    }
}

public class 응급실 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] patient = new int[n];
        for(int i=0;i<n;i++){
            patient[i] = scan.nextInt();
        }

        System.out.println(mySol(n,m,patient));
    }
    private static int mySol(int n, int m, int[] patient) {
        int result = 0;
        Queue<Patient> que = new LinkedList<>();
        for(int i = 0;i<n;i++) que.offer(new Patient(i, patient[i]));

        while(!que.isEmpty()){
            Patient tmp = que.poll();
            for(Patient x : que){
                if(x.score > tmp.score){
                    que.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                if(tmp.id == m)return ++result;
                else result++;
            }
        }
        return result;
    }
}
