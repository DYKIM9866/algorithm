package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q10989 {
	//수 정렬하기3
	
	static int[] arr;
	static int[] sorted;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		sorted = new int[N];
		int[] cnt = new int[10001];
		int i,val;
		for(i=0;i<N;i++) {
			val = Integer.parseInt(bf.readLine());
			cnt[val] += 1;
		}
		for(i=0;i<cnt.length;i++) {
			while(cnt[i]>0) {
				System.out.println(i);
				cnt[i]--;
			}
		}
		
		//Arrays.sort(arr);
		//mergeSort(0,arr.length-1);
		//quickSort(0,arr.length-1);
		
		/*for(i=0;i<arr.length;i++) {
			bw.write(String.valueOf(arr[i])+"\n");
		}
		
		bf.close();
		bw.flush();
		bw.close();*/
	}
	
	public static void quickSort(int x,int y) {
		
		int left = x, right = y, pivot = arr[(x+y)/2], temp;
		
		do{
			while(pivot > arr[left]) left++;
			while(pivot < arr[right]) right--;
			if(left <=right) {
				temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}while(left <= right);
		
		if(x < right) quickSort(x,right);
		if(y > left) quickSort(left,y);
		
	}
	
	public static void mergeSort(int x,int y) {
		
		if(x<y) {
			int mid = (x+y)/2;
			mergeSort(x,mid);
			mergeSort(mid+1,y);
			merge(x,mid,y);
		}
	}
	
	public static void merge(int x,int mid,int y) {
		
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
				sorted[k]=arr[t];
				k++;
			}
		}
		
		for(int t=x;t<y;t++) {
			arr[t] = sorted[t];
		}
		
	}

}
