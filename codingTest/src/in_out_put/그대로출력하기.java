package in_out_put;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그대로출력하기 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while(true) {
				String str = bf.readLine();
				if(str.equals("")) {
					break;
				}
				System.out.println(str);
			}
		} catch (Exception e) {
			
		}
	}
}
