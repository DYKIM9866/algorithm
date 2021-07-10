package sort;

public class 버블정렬 {
	
	public static void main(String[] args) {
		
		int[] arr = {2,7,4,6,8,10,5,1,3,9}; 
		int temp;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(int abc : arr) {
			 System.out.println(abc);
		 }

		
	}

}
