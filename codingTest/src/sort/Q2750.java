package sort;

import java.util.Scanner;

public class Q2750 {
	//수 정렬하기
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int t = sc.nextInt();
		int[] arr = new int[t];
		int i,j,temp,min,index=0;
		
		for(i=0;i<t;i++) {
			arr[i] = sc.nextInt();
		}
		
		/*//버블정렬
		for(i=0;i<arr.length;i++) {
			for(j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}*/
		
		/*//선택정렬
		for(i=0;i<arr.length;i++) {
			min = 1001;
			for(j=i;j<arr.length;j++) {
				if(arr[j]<min) {
					min = arr[j];
					index = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}*/
		
		//삽입정렬
		
		for(i=0;i<arr.length-1;i++) {
			index = i;
			while(index>=0 && arr[index]>arr[index+1]) {
				temp = arr[index];
				arr[index] = arr[index+1];
				arr[index+1] = temp;
				index--;
			}
			
		}
		
		//출력
		for(int abc : arr) {
			 System.out.println(abc);
		 }

	}

}
