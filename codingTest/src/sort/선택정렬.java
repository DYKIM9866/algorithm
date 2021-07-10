package sort;

public class 선택정렬 {
	
	 public static void main(String[] args) {
		
		 int[] arr = {2,7,4,6,8,10,5,1,3,9};
		 int min;			//최소값
		 int index = 0;		//index저장해 줄 곳
		 int temp;			//값 교환시 사용
		 
		 for(int i=0;i<arr.length;i++) {
			 min = 999;
			 for(int j=i;j<arr.length;j++) {
				 if(min>arr[j]) {//최소값보다 작다면
					 min = arr[j]; //최소값으로 바꿔주고
					 index=j; //그 인덱스 넣어주기
				 }
			 }
			 temp = arr[i];
			 arr[i] = arr[index];
			 arr[index] = temp; 
		 }
		 for(int abc : arr) {
			 System.out.println(abc);
		 }
	}

}
