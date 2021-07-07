package in_out_put;

import java.util.Scanner;

public class CalculatorDaTE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] day = {"SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		int M =sc.nextInt();
		int D = sc.nextInt();
		
		if(M==1) {
			if(D==1) {
				System.out.println("MON");
				return;
			}
			System.out.println(day[D%7]);
			return;
		}
		
		for(int i=1;i<M;i++){
			if(i==2) {
				D+=28;
			}else if(i==4 || i==6 || i==9 || i==11) {
				D+=30;
			}else {
				D+=31;
			}
		}
		System.out.println(day[D%7]);
	}

}
