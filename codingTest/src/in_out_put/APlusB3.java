package in_out_put;

import java.util.Scanner;

public class APlusB3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			System.out.println(sc.nextInt()+sc.nextInt());
		}
	}
}
