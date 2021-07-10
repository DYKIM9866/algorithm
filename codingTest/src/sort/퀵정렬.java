package sort;

public class 퀵정렬 {
	
	static int[] arr = {2,7,4,6,8,10,5,1,3,9}; 
	
	public static void main(String[] args) {
		quickSort(0,arr.length-1);
		for(int abc : arr) {
			 System.out.print(abc+" ");
		 }
	}
	
	public static void quickSort(int start,int end) {
		
		int temp;
		
		if(start>=end) {
			return;
		}
		
		int pivot = start;
		int i = start+1;
		int j = end;
		
		while(i <= j) { //엇갈릴 때까지
			while(i <= end && arr[i]<=arr[pivot]) {
				i++;
			}
			while(arr[j]>=arr[pivot] && j>start) {
				j--;
			}
			
			if(i>j) {//엇갈렸을 때
				temp = arr[pivot];
				arr[pivot] = arr[j];
				arr[j] = temp;
				
			}else {//엇갈리지 않았을 때
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		quickSort(start, j-1);
		quickSort(j+1, end);
		
	}

}
