package online.algorithm;

/**
 * 선택정렬
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] intArr = {10,5,4,9,3,7,6,1,2,8};

        for(int a : intArr){
            System.out.print(a + " ");
        }
        System.out.println();

        for(int i=0;i<intArr.length-1;i++){
            int idx = i;
            for(int j=i;j<intArr.length;j++){
                if(intArr[idx] > intArr[j]){
                    idx = j;
                }
            }

            int temp = intArr[i];
            intArr[i] = intArr[idx];
            intArr[idx] = temp;
        }

        for(int a : intArr){
            System.out.print(a + " ");
        }
    }
}
