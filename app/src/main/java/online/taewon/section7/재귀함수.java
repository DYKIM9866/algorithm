package online.taewon.section7;

public class 재귀함수 {
    public static void main(String[] args) {
        mySol(3);
    }

    private static void mySol(int n) {
        if(n == 0) return;
        mySol(n-1);
        System.out.print(n + " ");
    }
}
