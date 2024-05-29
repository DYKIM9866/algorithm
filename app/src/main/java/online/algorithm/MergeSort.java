package online.algorithm;

/*
    병합정렬
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,9,2,7,3,1,4,6,8};
//        int[] arr = {4,2,1,3};

        mergeSort(arr,0,arr.length-1);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if(start >= end) return;

        int mid = (end + start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        merge(arr,start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int idx = 0; //temp 인덱스
        int left = start; //왼 리스트 시작
        int right = mid + 1; //오 리스트 시작

        while(left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                temp[idx++] = arr[left++];
            }else{
                temp[idx++] = arr[right++];
            }
        }
        while(left <= mid){
            temp[idx++] = arr[left++];
        }
        while(right <= end){
            temp[idx++] = arr[right++];
        }

        for(int i=start;i<=end;i++){
            arr[i] = temp[i-start];
        }
    }

}
