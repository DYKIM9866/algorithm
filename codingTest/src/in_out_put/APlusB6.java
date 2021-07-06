package in_out_put;

import java.util.Scanner;

public class APlusB6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			String[] a = new String[2];
			a = sc.next().split(",");
			System.out.println(Integer.parseInt(a[0])+Integer.parseInt(a[1]));
		}
	}

}
