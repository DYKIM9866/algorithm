package online.judge.algorithm;

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

        for(int i=0;i<intArr.length;i++){
            int min = 999; //최대값
            for(int j=i;j<intArr.length;j++){
                if(intArr[j] < min){
                    min = intArr[j];
                    int temp = intArr[i];
                    intArr[i] = intArr[j];
                    intArr[j] = temp;
                }
            }
        }

        for(int a : intArr){
            System.out.print(a + " ");
        }
    }
}
