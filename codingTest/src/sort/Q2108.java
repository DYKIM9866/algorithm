package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2108 {
	//통계학
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		double sum=0;	//평균을 구할 때 소수점이 버려지는 것을 방지하기 위해 double로 정의
		int mid=0,mode=0; 	//중간값, 최빈값
		int[] arr = new int[8001];	//counting sort를 위한 배열 선언
		int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
		
		int i,val;	//사용 할 변수들
		
		int N = Integer.parseInt(bf.readLine());
		for(i=0;i<N;i++) {
			val = Integer.parseInt(bf.readLine());
			arr[val+4000]++;	//음수값 해결하기 위해 +4000
			sum+=val;
			if(val<min) min=val;
			if(val>max) max=val;
		}
		
		int count=0;	//중간값 계산을 위해 사용
		int mode_val=0;	//최빈값 계산을 위해 사용
		
		boolean check=false;	//최빈값 구할 때 두번째로 작은 수를 구하기 위함
		
		for(i=min+4000;i<=max+4000;i++) {//값이 존재하는 범위안에서만 
			if(arr[i]>0) {
				
				//중간값 찾기
				if(count<(N+1)/2) {//값이 존재하는 부분에 대해서 전체 개수에 절반에 못 미칠 때 까지 수행
					count+=arr[i];
					mid = i-4000;
				}
				
				if(mode_val<arr[i]) {
					mode_val = arr[i];
					mode = i-4000;
					check=true;	//첫번째 나오는 값일 경우 true
				}else if(mode_val==arr[i] && check==true) {//전에 한번 나왔었어야 실행 됨
					mode = i-4000;
					check=false;
				}
			}
		}
		
		System.out.println((int)Math.round(sum/N));
		System.out.println(mid);
		System.out.println(mode);
		System.out.println(max-min);
	}

}
