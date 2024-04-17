package online.algorithm;

/**
 * 삽입정렬
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] intArr = {10,5,4,9,3,7,6,1,2,8};

        for(int i=0;i<intArr.length-1;i++){
            int j = i;
            while(j >= 0 && intArr[j] > intArr[j+1]){
                int temp = intArr[j];
                intArr[j] = intArr[j+1];
                intArr[j+1] = temp;
                j--;
            }
        }

        for(int a : intArr){
            System.out.print(a + " ");
        }
    }
}
