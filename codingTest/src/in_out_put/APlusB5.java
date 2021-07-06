package in_out_put;

import java.util.Scanner;

public class APlusB5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a==0 && b==0) {
				return;				
			}
			System.out.println(a+b);
		}
	}
}
