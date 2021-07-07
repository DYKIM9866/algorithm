package in_out_put;

import java.util.Scanner;

public class 숫자의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		String str = sc.next();
		int result = 0;
		
		for(int i=0;i<t;i++) {
			result += str.charAt(i)-48;
		}
		System.out.println(result);
	
	}

}
