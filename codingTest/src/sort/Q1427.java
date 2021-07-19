package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		char[] chr = bf.readLine().toCharArray();
		int[] counting = new int[10];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<chr.length;i++) {
			counting[chr[i]-'0']++;
		}
		for(int i=counting.length-1;i>=0;i--) {
			while(counting[i]>0) {
				sb.append(i);
				counting[i]--;
			}
		}
		System.out.println(sb);

	}

}
