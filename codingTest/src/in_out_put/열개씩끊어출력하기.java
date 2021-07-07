package in_out_put;

import java.util.Scanner;

public class 열개씩끊어출력하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		String str = sc.next();
		
		int a = str.length()/10;
		
		for(int i=0;i<a;i++) {
			result.append(str.substring(i*10,(i+1)*10));
			result.append("\n");
		}
		
		result.append(str.substring(a*10));
		
		System.out.println(result);
	}

}
