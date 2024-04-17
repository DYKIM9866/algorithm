package online.algorithm;

/**
 * 버블정렬
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] intArr = {10,5,4,9,3,7,6,1,2,8};

        for(int i=0;i<intArr.length-1;i++){
            for(int j=0;j<intArr.length-1-i;j++){
                if(intArr[j] > intArr[j+1]){
                    int temp = intArr[j];
                    intArr[j] = intArr[j+1];
                    intArr[j+1] = temp;
                }
            }
        }

        for(int a : intArr){
            System.out.print(a + " ");
        }

    }
}
