package sort;

public class 삽입정렬 {
	
	public static void main(String[] args) {
		
		int[] arr = {2,7,4,6,8,10,5,1,3,9}; 
		int temp,index;
		
		for(int i=0;i<arr.length-1;i++) {
			index=i;
			while(index>=0 && arr[index]>arr[index+1]) {
				temp = arr[index];
				arr[index] = arr[index+1];
				arr[index+1] = temp;
				index-=1;
			}
		}
		
		for(int abc : arr) {
			 System.out.println(abc);
		 }
		
	}

}
