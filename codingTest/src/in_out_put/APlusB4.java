package in_out_put;

import java.util.Scanner;

public class APlusB4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			
			System.out.println(sc.nextInt()+sc.nextInt());
		}
		sc.close();
	}

}
