package sort;

public class 병합정렬 {

static int[] sorted = new int[8];
	
	public static void main(String[] args) {
		
		int[] arr = {8,5,3,2,1,7,3,4};
		mergeSort(arr, 0, arr.length-1);
		
		for(int z:arr) {
			System.out.print(z+" ");
		}
		
		
	}
	
	public static void merge(int[] arr,int x,int mid,int y) {
		
		int i = x;
		int j = mid+1;
		int k = x;
		
		//작은거 부터 넣어주기
		while(i<=mid && j<=y) {
			if(arr[i]<=arr[j]) {
				sorted[k] = arr[i];
				i++;
			}else {
				sorted[k] = arr[j];
				j++;
			}
			k++;
		}
		
		//나머지 넣어주기
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
		//원래 배열에 넣어주기
		for(int t=x;t<=y;t++) {
			arr[t] = sorted[t];
		}
	}
	
	public static void mergeSort(int[] arr,int x,int y) {
		//값이 1보다 커야
		if(x<y) {
			int mid = (x+y)/2;
			mergeSort(arr, x, mid);
			mergeSort(arr, mid+1, y);
			merge(arr, x, mid, y);
		}
	}


}
