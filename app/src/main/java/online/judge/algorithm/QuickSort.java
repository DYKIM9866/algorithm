package online.judge.algorithm;

/**
 * 퀵 정렬
 * 미완 어려움..
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] intArr = {5,3,8,4,9,1,6,2,7,};
        int pivot = 0;

        int lo = 1;
        int hi = intArr.length - 1;

        while (intArr[pivot] > intArr[lo]){
            lo++;
        }
        while(intArr[pivot] < intArr[hi]){
            hi++;
        }

        int temp = intArr[lo];
        intArr[lo] = intArr[hi];
        intArr[hi] = temp;

        if(lo >= hi){

        }

    }

    private static void quickSort(int[] intArr) {

    }


}
