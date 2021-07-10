package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2751 {
	//수 정렬하기 2
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(bf.readLine());
		int[] arr = new int[t];
		int i;
		
		for(i=0;i<t;i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		quickSort(arr,0, t-1);
		
		for(int z : arr) {
			 System.out.println(z);
		 }
		
	}

	public static void quickSort(int[] arr,int start,int end) {
		if(start>=end) {
			return;
		}
		
		int pivot = start;
		int i = start+1;
		int j = end;
		int temp;
		
		while(i<=j) {
			while(i<=end && arr[i]<=arr[pivot]) {
				i++;
			}
			while(arr[j]>=arr[pivot] && j>start) {
				j--;
			}
			
			if(i>j) {
				temp = arr[j];
				arr[j] = arr[pivot];
				arr[pivot] = temp;
			}else {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		quickSort(arr,start, j-1);
		quickSort(arr,j+1, end);
	}
}
