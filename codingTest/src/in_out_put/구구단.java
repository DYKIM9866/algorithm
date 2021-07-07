package in_out_put;

import java.util.Scanner;

public class 구구단 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i=1;i<10;i++) {
			System.out.printf("%d * %d = %d\n",t,i,t*i);
		}
	}

}
