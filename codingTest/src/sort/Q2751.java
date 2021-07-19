package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2751 {
	//수 정렬하기 2
	
	static int[] sorted;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Q2751 sort = new Q2751();
		
		int t = Integer.parseInt(bf.readLine());
		int[] arr = new int[t];
		sorted = new int[t];
		for(int i=0;i<t;i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		sort.mergeSort(arr,0,arr.length-1);
		
		for(int i=0;i<arr.length;i++) {
	    	  bw.write(String.valueOf(arr[i])+"\n"); // 출력
	     }
		
		bw.flush();
	    bw.close();
	}
	public void mergeSort(int[] arr,int x,int y) {
		
		if(x<y) {
			int mid = (x+y)/2;
			mergeSort(arr, x, mid);
			mergeSort(arr, mid+1, y);
			merge(arr,x,mid,y);
		}
	}
	public static void merge(int[] arr,int x,int mid,int y) {
		
		int i = x;
		int j = mid+1;
		int k = x;
		
		while(i<=mid && j<=y) {
			if(arr[i] < arr[j]) {
				sorted[k] = arr[i];
				i++;
			}else {
				sorted[k] = arr[j];
				j++;
			}
			k++;
		}
		
		if(i>mid) {
			for(int t=j;t<=y;t++) {
				sorted[k] = arr[t];
				k++;
			}
		}else {
			for(int t=i;t<=mid;t++) {
				sorted[k] = arr[t];
				k++;
			}
		}
		
		for(int t=x;t<=y;t++) {
			arr[t] = sorted[t];
		}
		
	}
	

	//퀵정렬
	/*public static void main(String[] args) throws IOException {
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
	}*/
}
